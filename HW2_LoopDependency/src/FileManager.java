import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.lang.System.exit;

/**
 * File manager class which handles all operations based on dependency check and work with files.
 */
public final class FileManager {

    // Path to the root directory.
    private Path rootDirectoryPath;

    // Files which were attended during the traversal.
    private final Set<Path> attendedFiles;

    // Consequently united files.
    private final List<Path> unitedFiles;

    /**
     * Constructor which initializes the fields with empty collections to avoid null.
     */
    public FileManager() {
        attendedFiles = new HashSet<>();
        unitedFiles = new ArrayList<>();
    }

    /**
     * Function which gets and validates the absolute path of root directory.
     */
    public void initRootDirectory() {
        do {
            // Get input.
            ConsoleLogger.log(ConsoleLogs.ASK_TO_ENTER_ROOT_DIRECTORY_NAME);
            rootDirectoryPath = scanDirectoryPathName();

            // Check if not a directory.
            if (!new File(rootDirectoryPath.toUri()).isDirectory()) {
                ConsoleLogger.log(FileManagerLogs.NOTIFY_DIRECTORY_NOT_EXIST);
            }
        } while (!new File(rootDirectoryPath.toUri()).isDirectory());

        // Log success.
        ConsoleLogger.log(FileManagerLogs.NOTIFY_ROOT_DIRECTORY_PATH_WAS_ENTERED_SUCCESSFUL);
    }

    /**
     * Accessor for the root directory absolute path.
     * @return Absolute path to root directory.
     */
    public Path getRootDirectoryPath() {
        return rootDirectoryPath;
    }

    /**
     * Function which traverses all files and directories to extract the existence of loop dependency.
     * @param absolutePath Absolute path to directory or file.
     */
    public void traverseDirectory(Path absolutePath) {
        // Check for existence of directory with received absolute path.
        if (!Files.exists(absolutePath)) {
            ConsoleLogger.log(FileManagerLogs.NOTIFY_DIRECTORY_NOT_EXIST);
            return;
        }

        // Getting list of all directories and files.
        File[] files = (new File(absolutePath.toUri())).listFiles();
        if (files == null) {
            return;
        }

        for (var file : files) {
            // Walk through files.
            if (file.isFile()) {
                // Read file data to find other dependencies.
                readFileData(file);
            }
        }

        for (var file : files) {
            // Walk through directories.
            if (file.isDirectory()) {
                // Traverse directory within a recursive call.
                traverseDirectory(file.toPath());
            }
        }
    }

    /**
     * Function which prints united files to the console.
     */
    public void printUnitedFilesToConsole() {
        for (var file : unitedFiles) {
            System.out.println(file);
        }
    }

    /**
     * Function which writes data from united files to one output file.
     */
    public void writeUnitedDataToFile() {
        // Get absolute path to output file.
        Path outputPathFileName = getAndPrepareOutputPathFileName();

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(outputPathFileName.toString(), false))
        ) {
            for (var path : unitedFiles) {
                // Get all content from current file.
                List<String> content = Files.readAllLines(path);

                // Write content to output file.
                for (var line : content) {
                    bufferedWriter.write(line + "\n");
                }

                bufferedWriter.write('\n');
            }
        } catch (IOException e) {
            ConsoleLogger.log(FileManagerLogs.NOTIFY_SYSTEM_ERROR_IOEXCEPTION_DETECTED);
            return;
        }

        // Log success.
        ConsoleLogger.log(FileManagerLogs.UNITED_DATA_WRITTEN_SUCCESSFULLY);
    }

    /**
     * Function which scans the entered absolute path for the directory.
     * @return Path to the directory.
     */
    private Path scanDirectoryPathName() {
        Scanner scanner = new Scanner(System.in);
        return Path.of(scanner.nextLine());
    }

    /**
     * Function which reads file and searches for the dependency existence.
     * @param file Input file with data and maybe dependencies to other files.
     */
    private void readFileData(File file) {
        if (!attendedFiles.contains(file.toPath())) {

            // Check existence of file.
            if (!Files.exists(file.toPath())) {
                ConsoleLogger.log(FileManagerLogs.NOTIFY_FILE_NOT_EXIST);
                System.out.printf("[%s]\n", file.getName());
                return;
            }

            // Add path to attended files set.
            attendedFiles.add(file.toPath());

            // Read file data.
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getPath()))) {

                String line;
                while ((line = bufferedReader.readLine()) != null) {

                    // Check for dependencies existences.
                    if (line.startsWith("require ")) {
                        Path newPathName = rootDirectoryPath.resolve(line.substring(9, line.length() - 1));
                        // Recursively read data from dependency file.
                        readFileData(new File(newPathName.toUri()));
                    }
                }
            } catch (IOException e) {
                ConsoleLogger.log(FileManagerLogs.NOTIFY_SYSTEM_ERROR_IOEXCEPTION_DETECTED);
            }

            // Add current file to united files only after all dependencies check.
            unitedFiles.add(file.toPath());

        } else if (!unitedFiles.contains(file.toPath())) {
            ConsoleLogger.log(FileManagerLogs.NOTIFY_LOOP_DEPENDENCY_FOUND);

            exit(0);
        }
    }

    /**
     * Function which gets absolute path to the directory and makes output path filename.
     * @return Path to the output file.
     */
    private Path getAndPrepareOutputPathFileName() {
        Path path;

        do {
            ConsoleLogger.log(FileManagerLogs.ASK_TO_ENTER_OUTPUT_FILE_NAME);
            path = scanDirectoryPathName();

            if (!Files.exists(path)) {
                ConsoleLogger.log(FileManagerLogs.NOTIFY_DIRECTORY_NOT_EXIST);
            }

            if (new File(path.toUri()).isFile()) {
                ConsoleLogger.log(FileManagerLogs.NOTIFY_NOT_DIRECTORY_ENTERED);
            }
        } while (!Files.exists(path) || new File(path.toUri()).isFile());

        path = path.resolve("output.txt");

        return path;
    }

}
import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * File manager class which handles all operations based on dependency check and work with files.
 */
public final class FileManager {

    // Path to the root directory.
    private Path rootDirectoryPath;

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
     * Function which scans the entered absolute path for the directory.
     * @return Path to the directory.
     */
    private Path scanDirectoryPathName() {
        Scanner scanner = new Scanner(System.in);
        return Path.of(scanner.nextLine());
    }
}
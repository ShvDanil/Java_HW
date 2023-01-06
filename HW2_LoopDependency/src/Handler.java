import java.util.Scanner;

/**
 * The class which handles the main flow of the program and invokes necessary functions.
 */
public class Handler {

    // The instance of file manager which handles all operations corresponding to files.
    FileManager fileManager = new FileManager();

    /**
     * Function which regulate all program flow calling other functions.
     */
    public void execute() {
        instructUser();

        getRootDirectoryFromUser();

        askUserToContinueToStartDependencyCheck();

        performDependencyCheck();

        printUnitedFilesToConsole();
    }

    /**
     * Function which prints instructions and introduction of the program to the console.
     */
    private void instructUser() {
        ConsoleLogger.log(ConsoleLogs.INSTRUCTIONS);
        ConsoleLogger.log(ConsoleLogs.LINES_SEPARATOR);
    }

    /**
     * Function which invokes getting of the existing root directory for dependency check.
     */
    private void getRootDirectoryFromUser() {
        fileManager.initRootDirectory();
    }

    /**
     * Function which asks to write something to start dependency check.
     */
    private void askUserToContinueToStartDependencyCheck() {
        ConsoleLogger.log(ConsoleLogs.LINES_SEPARATOR);

        ConsoleLogger.log(ConsoleLogs.ASK_TO_PRESS_KEY_TO_CONTINUE_SEARCH_BY_PATH);

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println();
        ConsoleLogger.log(ConsoleLogs.LINES_SEPARATOR);
    }

    /**
     * Function which invokes the method of dependency check in file manager.
     */
    private void performDependencyCheck() {
        fileManager.traverseDirectory(fileManager.getRootDirectoryPath());
    }

    /**
     * Function which prints all united files to the console.
     */
    private void printUnitedFilesToConsole() {
        ConsoleLogger.log(ConsoleLogs.NOTIFY_ABOUT_ALL_FOUND_FILES_OUTPUT);
        fileManager.printUnitedFilesToConsole();
    }
}

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
}

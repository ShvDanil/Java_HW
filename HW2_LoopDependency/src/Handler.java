/**
 * The class which handles the main flow of the program and invokes necessary functions.
 */
public class Handler {
    /**
     * Function which regulate all program flow calling other functions.
     */
    public void execute() {
        instructUser();


    }

    /**
     * Function which prints instructions and introduction of the program to the console.
     */
    private void instructUser() {
        ConsoleLogger.log(ConsoleLogs.INSTRUCTIONS);
        ConsoleLogger.log(ConsoleLogs.LINES_SEPARATOR);
    }
}

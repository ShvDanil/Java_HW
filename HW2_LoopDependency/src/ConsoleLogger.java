/**
 * Logger class which prints logs to the console.
 */
public final class ConsoleLogger {

    /**
     * Prints the console log from handler to the user's console.
     * @param log String representation of log from enum.
     */
    public static void log(ConsoleLogs log) {
        System.out.print(log);
    }

    /**
     * Prints the file manager log to the user's console.
     * @param log String representation of log from enum.
     */
    public static void log(FileManagerLogs log) {
        System.out.print(log);
    }

}

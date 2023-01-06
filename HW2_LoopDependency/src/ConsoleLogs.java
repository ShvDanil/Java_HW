/**
 * Logs to console from handler concerning determined cases based on common program flow.
 */
public enum ConsoleLogs {

    /**
     * Separates lines with '—' sign for external attractiveness of the console output.
     */
    LINES_SEPARATOR {
        @Override
        public String toString() {
            return """
                — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — —

                """;
        }
    },

    /**
     * Prints the instructions to the console.
     */
    INSTRUCTIONS {
        @Override
        public String toString() {
            return """
            [Introduction]
            Hello! Glad to see you in program "Loop Dependency Checker".
            
            [Instructions]
            The instructions of that program are extremely straight.
            
            [Condition] -> you will be asked to enter a root directory and program has to define whether there\040
            exists a loop dependency in text files of directory or not.
            
            [Result] -> if loop dependency is indicated, you will be notified, otherwise, it doesn't exist in directory.
            
            """;
        }
    },

    /**
     * Asks to enter the absolute path to the root directory.
     */
    ASK_TO_ENTER_ROOT_DIRECTORY_NAME {
        @Override
        public String toString() {
            return """
                Enter root directory absolute path:
                ->\040""";
        }
    },

    /**
     * Asks to enter something to continue program execution and start dependency check.
     */
    ASK_TO_PRESS_KEY_TO_CONTINUE_SEARCH_BY_PATH {
        @Override
        public String toString() {
            return """
                [Continue] -> press any key or write something to start "Loop Dependency Checker" for entered directory.
                ->\040""";
        }
    }

}
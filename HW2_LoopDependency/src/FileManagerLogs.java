/**
 * Logs to console from file manager concerning determined cases.
 */
public enum FileManagerLogs {

    /**
     * Notifies that entered root to directory does not exist.
     */
    NOTIFY_DIRECTORY_NOT_EXIST {
        @Override
        public String toString() {
            return """
                                    
                    [Error] -> such directory doesn't seem to exist. Try again!
                                    
                    """;
        }
    },

    /**
     * Notifies that the path to root directory was found and the status of operation is successful.
     */
    NOTIFY_ROOT_DIRECTORY_PATH_WAS_ENTERED_SUCCESSFUL {
        @Override
        public String toString() {
            return """
                                    
                    [Success] -> the path to root directory is found!
                                    
                    """;
        }
    },

    /**
     * Notifies that entered file does not exist.
     */
    NOTIFY_FILE_NOT_EXIST {
        @Override
        public String toString() {
            return """
                                    
                    [Error] -> such file doesn't seem to exist. Try again!
                    """;
        }
    },

    /**
     * Notifies that during program execution the IOException was caught.
     */
    NOTIFY_SYSTEM_ERROR_IOEXCEPTION_DETECTED {
        @Override
        public String toString() {
            return """
                
                [SystemError] -> IOException was detected!
                """;
        }
    },

    /**
     * Notifies that in files there exists the loop dependency.
     */
    NOTIFY_LOOP_DEPENDENCY_FOUND {
        @Override
        public String toString() {
            return """
                [Error] -> the loop dependency was indicated! The dependencies in directory files are incorrect!
                
                """;
        }
    },

    /**
     * Notifies that data was successfully written to the output file.
     */
    UNITED_DATA_WRITTEN_SUCCESSFULLY {
        @Override
        public String toString() {
            return """
                
                [Success] -> the data was written successfully to files!
                """;
        }
    },

    /**
     * Asks to enter the output filename where all united data will be written.
     */
    ASK_TO_ENTER_OUTPUT_FILE_NAME {
        @Override
        public String toString() {
            return """
                
                Enter absolute path of output directory:
                ->\040""";
        }
    },

    /**
     * Notifies that there was entered not a directory.
     */
    NOTIFY_NOT_DIRECTORY_ENTERED {
        @Override
        public String toString() {
            return """
                
                [Error] -> not a directory was entered. Try again!
                
                """;
        }
    },

}
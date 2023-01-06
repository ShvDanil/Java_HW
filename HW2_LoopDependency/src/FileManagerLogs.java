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

}
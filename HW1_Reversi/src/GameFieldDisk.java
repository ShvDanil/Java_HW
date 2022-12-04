public enum GameFieldDisk {

    /// Different players.
    WHITE_PLAYER("White"),
    BLACK_PLAYER("Black"),
    NO_PLAYER("-");

    /// Disk shown on the square field.
    private final String diskOnSquare;

    /// Constructor which initializes the field of disk on square.
    GameFieldDisk(String disk) {
        diskOnSquare = disk;
    }

    /// Method which return the char representation of disk on square.
    public char getDiskOnSquareSymbol() {
        return diskOnSquare.charAt(0);
    }

    public String getDiskOnSquare() {
        return diskOnSquare;
    }
}
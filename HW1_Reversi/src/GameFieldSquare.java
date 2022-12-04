import java.util.Objects;

public class GameFieldSquare {

    /// Private fields.
    private final int row;
    private final int column;

    /// Constructor which initializes rows and columns amount.
    public GameFieldSquare(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int[] getCoordinates() {
        return new int[]{row, column};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameFieldSquare that = (GameFieldSquare) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "[" + (row + 1) + ", " + (column + 1) + "]";
    }
}

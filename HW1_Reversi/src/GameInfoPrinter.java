import java.util.ArrayList;
import java.util.HashMap;

public class GameInfoPrinter {

    /// Method which prints info about field.
    public void printFieldInfo(HashMap<GameFieldSquare, GameFieldDisk> positions) {
        System.out.println("R | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |");
        char[][] fieldToOutput = new char[8][8];

        for (GameFieldSquare position : positions.keySet()) {
            fieldToOutput[position.getCoordinates()[0]][position.getCoordinates()[1]] =
                    positions.get(position).getDiskOnSquareSymbol();
        }

        for (int row = 0; row < fieldToOutput.length; row++) {
            System.out.print((row + 1) + " | ");
            for (int column = 0; column < fieldToOutput[0].length; column++) {
                System.out.print(fieldToOutput[row][column] + "   ");
            }
            System.out.println();
        }
    }

    /// Method which print info about moves.
    public void printMovesInfo(ArrayList<ArrayList<GameFieldSquare>> movesInfo) {
        int count = 1;

        for (var move : movesInfo) {
            System.out.println("Move " + count++ + ": " + move.get(move.size() - 1));
            System.out.println("That way you will place disks of your color on: ");
            for (var square : move) {
                System.out.print(square + " ");
            }
            System.out.println("\n");
        }
    }
}

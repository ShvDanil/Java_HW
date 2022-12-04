import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameProcess {

    /// Private fields.
    private final GameField field = new GameField();
    private final GameInfoPrinter gameInfoPrinter = new GameInfoPrinter();

    //// Method which describes the game.
    public void play(String gameType) {
        GameFieldDisk currentDiskColor = GameFieldDisk.BLACK_PLAYER;
        do {
            var positions = field.getPositions();
            gameInfoPrinter.printFieldInfo(positions);

            var moves = field.findMoves(currentDiskColor);
            gameInfoPrinter.printMovesInfo(moves);

            if (gameType.equals("1") && currentDiskColor == GameFieldDisk.BLACK_PLAYER) {
                makeComputerMove(moves);
            }
            if (gameType.equals("2") || (gameType.equals("1") && currentDiskColor == GameFieldDisk.WHITE_PLAYER)) {
                makePersonMove(currentDiskColor, moves);
            }
            currentDiskColor = swapDiskColorToMove(currentDiskColor);
        } while (field.getWhiteAndBlackCount()[0] + field.getWhiteAndBlackCount()[1] != 64);

        int white = field.getWhiteAndBlackCount()[0];
        int black = field.getWhiteAndBlackCount()[1];
        if (white > black) {
            System.out.println("White player wins with " + white + " disks!");
            return;
        }
        if (white < black) {
            System.out.println("Black player wins with " + black + " disks!");
            return;
        }

        System.out.println("No one won but friendship did!");
        gameInfoPrinter.printFieldInfo(field.getPositions());
    }

    /// Method which executes the process of persons' move.
    private boolean makePersonMove(GameFieldDisk diskColor, ArrayList<ArrayList<GameFieldSquare>> availablePositions) {
        if (availablePositions.isEmpty()) {
            System.out.println("No move can be made because there are no options available!");
            return false;
        }
        Scanner scanner = new Scanner(System.in);
        int moveNumber;
        System.out.println(diskColor.getDiskOnSquare() + ", input move number: ");
        try {
            moveNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Not a number! Try input again!");
            return makePersonMove(diskColor, availablePositions);
        }
        if (moveNumber <= 0 || moveNumber > availablePositions.size()) {
            System.out.println("Incorrect option number! Try input again!");
            return makePersonMove(diskColor, availablePositions);
        }
        System.out.println("Making move #" + moveNumber);
        field.makeMoveOnField(availablePositions.get(moveNumber - 1), diskColor);
        return true;
    }

    /// Method which executes the process of computers' move.
    private void makeComputerMove(ArrayList<ArrayList<GameFieldSquare>> availablePositions) {
        if (availablePositions.isEmpty()) {
            System.out.println("No move can be made because there are no options available!");
            return;
        }
        Random random = new Random();
        int moveNumber = random.nextInt(availablePositions.size());
        System.out.println("Computer making move #" + (moveNumber + 1));
        field.makeMoveOnField(availablePositions.get(moveNumber), GameFieldDisk.BLACK_PLAYER);
    }

    /// Method which swaps the players after move.
    private GameFieldDisk swapDiskColorToMove(GameFieldDisk current) {
        if (current == GameFieldDisk.WHITE_PLAYER) {
            return GameFieldDisk.BLACK_PLAYER;
        }
        if (current == GameFieldDisk.BLACK_PLAYER) {
            return GameFieldDisk.WHITE_PLAYER;
        }
        return GameFieldDisk.NO_PLAYER;
    }
}

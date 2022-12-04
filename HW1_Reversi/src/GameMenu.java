import java.util.Scanner;

public class GameMenu {

    /// Private field.
    private final GameProcess gameProcess;

    /// Constructor which initializes the game process variable.
    public GameMenu() {
        gameProcess = new GameProcess();
    }

    /// Method which launches the game.
    public void launch() {
        System.out.println("This is a Reversi Game. Welcome!");
        System.out.println("Author: Shvetsov Danil Igorevich");
        System.out.println("You need to choose whether you want to play with a computer in a basic mode or with another player.");
        System.out.println("Input 1 for game with a computer, 2 for game with another player:");
        String gameType = inputGameType();
        gameProcess.play(gameType);
    }

    /// Method which gets the type of the game from user.
    private String inputGameType() {
        Scanner scanner = new Scanner(System.in);

        String gameType = scanner.nextLine();
        if (!gameType.equals("1") && !gameType.equals("2")) {
            System.out.println("No such game type. Correct input is 1 or 2!");
            return inputGameType();
        }

        return gameType;
    }
}

import java.util.ArrayList;

// Invoker.
public class Controller {
    // List of commands.
    private final ArrayList<Command> commands = new ArrayList<>();
    // Current executable command.
    private int currentCommand = 0;

    /**
     * Adding command to the list of commands.
     * @param command Command to add.
     */
    public void addCommand(Command command) {
        commands.add(command);
    }

    /**
     * Executes current command.
     */
    public void doCommand() {
        commands.get(currentCommand).execute();
        ++currentCommand;
    }

    /**
     * Executes undo of command.
     * @param times Amount of times to undo command.
     */
    public void undoCommand(int times) {
        for (int i = 0; i < times; ++i) {
            if (currentCommand > 0) {
                commands.get(--currentCommand).undo();
            }
        }
    }

    /**
     * Executes the repeat of command.
     * @param times Amount of times to repeat command.
     */
    public void redoCommand(int times) {
        for (int i = 0; i < times; ++i) {
            if (currentCommand < commands.size() - 1) {
                commands.get(currentCommand).execute();
                ++currentCommand;
            }
        }
    }
}

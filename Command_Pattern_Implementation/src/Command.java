// Command.
public abstract class Command {
    protected int operand;
    protected ArithmeticUnit arithmeticUnit;

    public abstract void execute();
    public abstract void undo();
}

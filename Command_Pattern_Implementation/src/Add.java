// Concrete command.
public class Add extends Command {
    /**
     * @param arithmeticUnit Arithmetic unit which executes arithmetic operation after getting signal.
     * @param operand Value to execute arithmetic operation.
     */
    Add(ArithmeticUnit arithmeticUnit, int operand) {
        this.arithmeticUnit = arithmeticUnit;
        this.operand = operand;
    }

    /**
     * Executes arithmetic operation.
     */
    @Override
    public void execute() {
        arithmeticUnit.execute('+', operand);
    }

    /**
     * Undoes the arithmetic operation.
     */
    @Override
    public void undo() {
        arithmeticUnit.execute('-', operand);
    }
}

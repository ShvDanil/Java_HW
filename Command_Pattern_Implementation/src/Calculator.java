// Client.
public class Calculator {
    // Controller.
    private final Controller controller = new Controller();

    // Unit for arithmetic operations.
    private final ArithmeticUnit arithmeticUnit = new ArithmeticUnit();

    Calculator() {
    }

    /**
     * @param command Command.
     * @return Result of arithmetic operation.
     */
    private int execute(Command command) {
        controller.addCommand(command);
        controller.doCommand();

        return arithmeticUnit.register;
    }

    /**
     * @param times Amount of repeats of undo.
     * @return Result of arithmetic operation.
     */
    public int undo(int times) {
        controller.undoCommand(times);

        return arithmeticUnit.register;
    }

    /**
     * @param times Amount of repeats of operation.
     * @return Result of arithmetic operation.
     */
    public int redo(int times) {
        controller.redoCommand(times);

        return arithmeticUnit.register;
    }

    /**
     * @param operand Value.
     * @return Value after adding operand.
     */
    public int add(int operand) {
        return execute(new Add(arithmeticUnit, operand));
    }

    /**
     * @param operand Value.
     * @return Value after subtracting operand.
     */
    public int subtract(int operand) {
        return execute(new Subtract(arithmeticUnit, operand));
    }

    /**
     * @param operand Value.
     * @return Value after multiplying operand.
     */
    public int multiply(int operand) {
        return execute(new Multiply(arithmeticUnit, operand));
    }

    /**
     * @param operand Value.
     * @return Value after dividing operand.
     */
    public int divide(int operand) {
        return execute(new Divide(arithmeticUnit, operand));
    }
}

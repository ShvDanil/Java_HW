// Receiver.
public class ArithmeticUnit {
    // Variable which registers the arithmetic operations result.
    public int register;

    /**
     * @return Arithmetic operations result.
     */
    public int getRegister() {
        return register;
    }

    /**
     * @param register Arithmetic operations result.
     */
    private void setRegister(int register) {
        this.register = register;
    }

    /**
     * Executes the operation with the value and updates register (storage) data.
     * @param operation Char representation of operation.
     * @param operand Value.
     */
    public void execute(char operation, int operand) {
        switch (operation) {
            case '+' -> {
                register += operand;
            }
            case '-' -> {
                register -= operand;
            }
            case '*' -> {
                register *= operand;
            }
            case '/' -> {
                register /= operand;
            }
        }
    }
}

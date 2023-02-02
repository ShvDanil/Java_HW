public class Main {
    /**
     * Entry point of program.
     * @param args Arguments.
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = 0;

        result = calculator.add(10);
        System.out.println(result);

        result = calculator.subtract(5);
        System.out.println(result);

        result = calculator.multiply(5);
        System.out.println(result);

        result = calculator.divide(25);
        System.out.println(result);

        result = calculator.undo(2);
        System.out.println(result);

        result = calculator.redo(3);
        System.out.println(result);
    }
}
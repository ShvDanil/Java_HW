public class Task2 {
    private static boolean isPrime(int number) {
        for (int i = 2; i < number; ++i) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void printPrimeNumbers(int leftBorder, int rightBorder) {
        for (int i = leftBorder; i <= rightBorder; ++i) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void execute() {
        int leftBorder = 2;
        int rightBorder = 100;
        System.out.printf("Prime numbers in collection [%d, %d]: ", leftBorder, rightBorder);
        printPrimeNumbers(leftBorder, rightBorder);
    }
}

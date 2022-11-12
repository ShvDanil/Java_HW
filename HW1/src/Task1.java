import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Task1 {
    private static int getArraySize() {
        Scanner in = new Scanner(System.in);
        int arraySize;
        do {
            System.out.print("Enter size of array: ");
            arraySize = in.nextInt();
            if (arraySize < 0) {
                System.out.println("Incorrect value was entered!\n");
                continue;
            }
            break;
        } while (true);

        return arraySize;
    }

    private static int[] generateArrayWithRandomNumbers(int arraySize) {
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; ++i) {
            array[i] = (int) (Math.random() * 100);
        }

        return array;
    }

    private static void printArrayItems(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static void printMaxInArray(int[] array) {
        int maxArrayValue = Arrays.stream(array).max().getAsInt();
        System.out.println("\nThe maximum number is: " + maxArrayValue);
    }

    private static void printMinInArray(int[] array) {
        int minArrayValue = Arrays.stream(array).min().getAsInt();
        System.out.println("The minimum number is: " + minArrayValue);
    }

    private static void printAverageArrayValue(int[] array) {
        OptionalDouble averageArrayValue = Arrays.stream(array).average();
        System.out.println("The average array value is: " + averageArrayValue.getAsDouble());
    }

    public static void execute() throws InterruptedException {
        int arraySize = getArraySize();

        System.out.println("\nArray is to be generated...");
        TimeUnit.SECONDS.sleep(1);
        int[] array = generateArrayWithRandomNumbers(arraySize);
        System.out.println("Array was generated successfully! You can see it below:");
        printArrayItems(array);

        printMaxInArray(array);
        printMinInArray(array);
        printAverageArrayValue(array);
    }
}

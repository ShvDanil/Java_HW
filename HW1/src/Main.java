import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("— — — — — — — — — — — — — — — — —");
        System.out.println("Task #1");
        Task1.execute();
        System.out.println("— — — — — — — — — — — — — — — — —");

        TimeUnit.SECONDS.sleep(5);

        System.out.println("\n— — — — — — — — — — — — — — — — —");
        System.out.println("Task #2");
        Task2.execute();
        System.out.println("— — — — — — — — — — — — — — — — —");
    }
}
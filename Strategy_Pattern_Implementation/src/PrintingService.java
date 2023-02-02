/**
 * Service which operates print of some data.
 */
public class PrintingService {
    // Type of print.
    private PrintStrategy printStrategy;


    /**
     * @return Print type.
     */
    public PrintStrategy getPrintStrategy() {
        return printStrategy;
    }

    /**
     * @param printStrategy Print type.
     */
    public void setPrintStrategy(PrintStrategy printStrategy) {
        this.printStrategy = printStrategy;
    }

    /**
     * Execution of print operation.
     */
    public void print() {
        printStrategy.print();
    }
}

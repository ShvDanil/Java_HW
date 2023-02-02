public class Main {
    /**
     * Prints the separator between lines.
     */
    private static void printSeparator() {
        System.out.println("— — — — — — — — — — — — — — — — — — — — — — — — — — — — — —\n");
    }

    /**
     * Entry point of program.
     * @param args Arguments.
     */
    public static void main(String[] args) {
        // Creating instance of printing service.
        PrintingService printingService = new PrintingService();

        // Creating instances of all existing printer models.
        PrintStrategy[] printerModels = new PrintStrategy[] {
            new InkjetPrinter(), new LaserPrinter(), new LEDPrinter(), new ThreeDPrinter()
        };

        // Setting model for print, execute print operation and separate lines to divide output.
        for (var model : printerModels) {
            printingService.setPrintStrategy(model);
            printingService.print();
            printSeparator();
        }
    }
}
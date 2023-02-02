/**
 * LED type of printer.
 */
public class LEDPrinter implements PrintStrategy {
    // Name of model.
    private final String modelName = "LEDPrinter";

    /**
     * @return Model name.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Executes print operation.
     */
    @Override
    public void print() {
        /*
        Printing actions started
        ...
        ...
        ...
        Printing actions ended
         */

        System.out.printf("[INFO] -> %s has printed data successfully.\n", modelName);
    }
}

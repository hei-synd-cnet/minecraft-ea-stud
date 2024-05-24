package ch.hevs.isi.core;

/**
 * The BooleanDataPoint class extends the DataPoint class and represents a data point that holds boolean values.
 */
public class BooleanDataPoint extends DataPoint {

    // Field to store the boolean value
    private Boolean value = null;

    /**
     * Constructor for creating a new BooleanDataPoint instance.
     * @param label The label of the data point.
     * @param isOutput Indicates whether the data point is an output.
     */
    public BooleanDataPoint(String label, boolean isOutput) {
        super(label, isOutput); // Call the constructor of the superclass
    }

    /**
     * Method to set the value of the BooleanDataPoint.
     * If the new value is different from the current value or the current value is null, update the data point.
     * @param newValue The new boolean value.
     */
    public void setValue(boolean newValue) {
        if ((value == null) || (value != newValue)) {
            value = newValue; // Update the value
            update(true); // Notify listeners of the update
        }
    }

    /**
     * Method to get the value of the BooleanDataPoint.
     * @return The boolean value of the data point.
     */
    public boolean getValue() {
        return value;
    }

    /**
     * Method to represent the BooleanDataPoint as a string.
     * @return A string representation of the BooleanDataPoint containing its label, output status, and value.
     */
    public String toString() {
        return "label = " + label + "\n" +
                "isOutput = " + isOutput + "\n" +
                "value = " + value;
    }
}
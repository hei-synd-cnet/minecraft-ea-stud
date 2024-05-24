package ch.hevs.isi.core;

/**
 * The FloatDataPoint class extends the DataPoint class and represents a data point that holds float values.
 */
public class FloatDataPoint extends DataPoint {

    // Field to store the float value
    private Float value = null;

    /**
     * Constructor for creating a new FloatDataPoint instance.
     * @param label The label of the data point.
     * @param isOutput Indicates whether the data point is an output.
     */
    public FloatDataPoint(String label, boolean isOutput){
        super(label, isOutput); // Call the constructor of the superclass
    }

    /**
     * Method to set the value of the FloatDataPoint.
     * If the new value is different from the current value or the current value is null, update the data point.
     * @param newValue The new float value.
     */
    public void setValue(Float newValue){
        if (value == null || !this.value.equals(newValue)) {
            value = newValue; // Update the value
            update(true); // Notify listeners of the update
        }
    }

    /**
     * Method to get the value of the FloatDataPoint.
     * @return The float value of the data point.
     */
    public Float getValue(){
        return value;
    }

    /**
     * Method to represent the FloatDataPoint as a string.
     * @return A string representation of the FloatDataPoint containing its label, output status, and value.
     */
    public String toString(){
        return "label = " + label + "\n"
                + "isOutput = " + isOutput + "\n"
                + "value = " + value;
    }
}
package ch.hevs.isi.core;

/**
 * Represents a data point that holds a float value.
 */
public class FloatDataPoint extends DataPoint {

    /** Attribute to store the float value. */
    protected float value;

    /**
     * Constructs a FloatDataPoint with the specified label and output flag.
     *
     * @param label the label of the data point
     * @param isOutput indicates whether the data point is an output
     */
    public FloatDataPoint(String label, boolean isOutput) {
        super(label);
        this.isOutput = isOutput;
    }

    /**
     * Sets the value of the data point.
     *
     * @param value the float value to set
     */
    public void setValue(float value) {
        this.value = value;
        // Notify all connectors
        update(true);
    }

    /**
     * Gets the value of the data point.
     *
     * @return the float value
     */
    public float getValue() {
        return value;
    }

    /**
     * Returns a string representation of the data point.
     *
     * @return the string representation of the float value
     */
    public String toString() {
        return String.valueOf(value);
    }
}

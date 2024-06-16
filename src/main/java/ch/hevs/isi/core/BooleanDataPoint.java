package ch.hevs.isi.core;

/**
 * Represents a data point that holds a boolean value.
 */
public class BooleanDataPoint extends DataPoint {

    /** Attribute to store the boolean value. */
    protected boolean value;

    /**
     * Constructs a BooleanDataPoint with the specified label and output flag.
     *
     * @param label the label of the data point
     * @param isOutput indicates whether the data point is an output
     */
    public BooleanDataPoint(String label, boolean isOutput) {
        super(label);
        this.isOutput = isOutput;
    }

    /**
     * Sets the value of the data point.
     *
     * @param value the boolean value to set
     */
    public void setValue(boolean value) {
        this.value = value;
        // Notify all connectors
        update(true);
    }

    /**
     * Gets the value of the data point.
     *
     * @return the boolean value
     */
    public boolean getValue() {
        return value;
    }

    /**
     * Returns a string representation of the data point.
     *
     * @return "1" if the value is true, otherwise "0"
     */
    public String toString() {
        if(value){
            return "1";
        }else{
            return "0";
        }
    }
}

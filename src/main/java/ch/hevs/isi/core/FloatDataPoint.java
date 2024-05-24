package ch.hevs.isi.core;

public class FloatDataPoint extends DataPoint{
    private Float value;

    /**
     *Constructor of the label
     * @param label Name of the datapoint
     * @param isOutput
     */
    public FloatDataPoint(String label, Boolean isOutput) {
    super(label, isOutput);
    }

    /**
     * Set the value of the datapoint
     * @param valueToSet
     */
    public void setValue(Float valueToSet){
        if (value != valueToSet)
        {
            value = valueToSet;
            update(true);
        }

    }

    /**
     * Get the float value of the datapoint
     * @return
     */
    public float getValue(){
        return value;
    }

    /**
     * @return the value in string
     */
    public String toString(){
        return String.valueOf(value);
    }
}

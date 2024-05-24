package ch.hevs.isi.core;

public class FloatDataPoint extends DataPoint{
    private Float value;

    /**
     *
     * @param label
     * @param isOutput
     */
    public FloatDataPoint(String label, Boolean isOutput) {
    super(label, isOutput);
    }
    void setValue(Float valueToSet){
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
    float getValue(){
        return value;
    }

    /**
     * Return the data point in String
     * @return
     */
    public String toString(){
        return String.valueOf(value);
    }
}

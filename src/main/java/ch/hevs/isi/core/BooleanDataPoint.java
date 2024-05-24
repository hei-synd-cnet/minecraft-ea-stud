package ch.hevs.isi.core;

/**
 * Class for the boolean data
 */
public class BooleanDataPoint extends DataPoint{
    private Boolean value = null;

    /**
     * Constructor of the class
     * @param label Name of the datapoint
     * @param isOutput
     */
    public BooleanDataPoint(String label, Boolean isOutput) {
        super(label, isOutput);
    }

    /**
     * @return value
     */
    public Boolean getValue() {
        return value;
    }

    /**
     * @param valueToSet
     */
    public void setValue(Boolean valueToSet) {
        if(value != valueToSet){
            value = valueToSet;
            update(true);
        }
    }

    /**
     * @return value of datapoint in String
     */
    public String toString(){
        return String.valueOf(value);
    }
}

package ch.hevs.isi.core;

/**
 * The public class BooleanDataPoint extends the Datapoint class.
 * This class works with boolean values.
 */
public class BooleanDataPoint extends DataPoint {
    private boolean value;

    public BooleanDataPoint(String label, boolean isOutput){

        super(label, isOutput);
    }

    public void setValue(boolean newValue) {
        if ((newValue ^ this.value) == true) {
            this.value = newValue;
            update(true);
        }
    }


    public boolean getValue(){

        return value;
    }

    public String toString(){
        return "label = " + label +"\n"
                + "isOutput = " + isOutput +"\n"
                + "value = " + value;
    }
}

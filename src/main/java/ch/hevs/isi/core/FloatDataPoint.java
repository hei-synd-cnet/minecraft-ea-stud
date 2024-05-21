package ch.hevs.isi.core;

/**
 * The public class FlaotDataPoint extends the Datapoint class.
 * This class works with float values.
 */
class FloatDataPoint extends DataPoint {
    private Float value;

    public FloatDataPoint(String label, boolean isOutput){
        super(label, isOutput);
    }

    public void setValue(Float value){
        this.value = value;
    }

    public Float getValue(){
        return value;
    }

    public String toString(){
        return "label = " + label +"\n"
                + "isOutput = " + isOutput + "\n"
                + "value = " + value;
    }
}

package ch.hevs.isi.core;

public class BooleanDataPoint extends DataPoint {
    private boolean value;

    public BooleanDataPoint(String label, boolean isOuput){
        super(label, isOutput);
    }

    public void setValue(boolean value){
        this.value = value;
    }

    public boolean getValue(){
        return value;
    }

    public String toString(){
        return "label = " + label
                + "isOutput = " + isOutput
                + "value = " + value;
    }
}

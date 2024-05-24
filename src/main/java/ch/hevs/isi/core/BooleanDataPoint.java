package ch.hevs.isi.core;

public class BooleanDataPoint extends DataPoint{
    private Boolean value = null;

    public BooleanDataPoint(String label, Boolean isOutput) {
        super(label, isOutput);
    }


    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean valueToSet) {
        if(value != valueToSet){
            value = valueToSet;
            update(true);
        }
    }

    public String toString(){
        return String.valueOf(value);
    }
}

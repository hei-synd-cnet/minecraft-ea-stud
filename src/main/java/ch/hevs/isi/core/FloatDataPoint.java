package ch.hevs.isi.core;

public class FloatDataPoint extends DataPoint {
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
        return "label = " + label
                + "isOutput = " + isOutput
                + "value = " + value;
    }
}

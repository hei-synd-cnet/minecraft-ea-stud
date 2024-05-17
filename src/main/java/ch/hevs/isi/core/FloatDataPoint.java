package ch.hevs.isi.core;

public class FloatDataPoint extends DataPoint{
    private Float value;
    public FloatDataPoint(String label, Boolean isOutput) {
    super(label, isOutput);
    }
    void setValue(Float valueToSet){
        value = valueToSet;
    }
    float getValue(){
        return value;
    }

    public String toString(){
        return "Label :" + super.getLabel()+ ", isOutput :" + String.valueOf(super.isOutput())+", Value :"
                + String.valueOf(value);
    }
}

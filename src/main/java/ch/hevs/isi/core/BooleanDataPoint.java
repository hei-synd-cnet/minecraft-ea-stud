package ch.hevs.isi.core;

public class BooleanDataPoint extends DataPoint{
    private Boolean value;

    protected BooleanDataPoint(String label, Boolean isOutput) {
        super(label, isOutput);
    }


    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public String toString(){
        return "label =" + super.getLabel() + "value =" + String.valueOf(value) + "Is ouput = " + String.valueOf(super.isOutput());
    }
}

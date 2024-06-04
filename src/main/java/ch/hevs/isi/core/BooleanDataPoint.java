package ch.hevs.isi.core;

public class BooleanDataPoint extends DataPoint {

    /**Attributes*/
    protected boolean value;

    /**Constructor*/
    public BooleanDataPoint(String label, boolean value) {
        super(label);
        this.value = value;
    }

    /**Methods*/
    public void setValue(boolean value) {
        this.value = value;
        // Notify all connectors
        update(true);
    }
    public boolean getValue() {
        return value;
    }
    public String toString() {
        if(value){
            return "1";
        }else{
            return "0";
        }

    }
}

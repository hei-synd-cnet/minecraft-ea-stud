package ch.hevs.isi.core;

public class FloatDataPoint extends DataPoint{

    /**Attributes*/
    protected float value;

    /**Constructor*/
    public FloatDataPoint(String label, float value) {
        super(label);
        this.value = value;
    }

    /**Methods*/
    public void setValue(float value) {
        this.value = value;
        // Notify all connectors
        update(true);
    }
    public float getValue() {
        return value;
    }
    public String toString() {
        return String.valueOf(value);
    }


}

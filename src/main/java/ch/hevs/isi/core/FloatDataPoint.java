package ch.hevs.isi.core;

public class FloatDataPoint extends DataPoint{
    private float value;
    public FloatDataPoint(String label, Boolean isOutput)
    {
        DataPoint(label, isOutput);
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

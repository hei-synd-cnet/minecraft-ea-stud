package ch.hevs.isi.core;

public class BooleanDataPoint extends DataPoint{
    private boolean value;
    public BooleanDataPoint(String label, Boolean isOutput)
    {
        DataPoint(label, isOutput);
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

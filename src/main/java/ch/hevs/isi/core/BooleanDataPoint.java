package ch.hevs.isi.core;

public class BooleanDataPoint extends DataPoint {
    private boolean value;

    public BooleanDataPoint(String label, Boolean isOutput) {
        super(label, isOutput);
        update();
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {

        if (this.value != value) {
            this.value = value;
            update();
        }

    }

    @Override
    public String toString() {
        return "BooleanDataPoint{" +
                "label='" + getLabel() + '\'' +
                ", isOutput=" + isOutput() +
                ", value=" + value +
                '}';
    }

}
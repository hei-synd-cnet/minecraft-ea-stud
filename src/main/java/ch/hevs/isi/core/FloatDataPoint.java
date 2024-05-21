package ch.hevs.isi.core;

public class FloatDataPoint extends DataPoint{
    private float value;
    public FloatDataPoint(String label, Boolean isOutput)
    {
        super(label, isOutput);
        update();
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        if (this.value != value) {
            this.value = value;
            update();
        }
    }

    @Override
    public String toString() {
        return "FloatDataPoint{" +
                "label='" + getLabel() + '\'' +
                ", isOutput=" + isOutput() +
                ", value=" + value +
                '}';
    }

}

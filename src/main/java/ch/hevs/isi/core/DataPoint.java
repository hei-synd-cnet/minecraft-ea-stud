package ch.hevs.isi.core;

public abstract class DataPoint {
    protected String label;
    protected Boolean isOutput;
    protected DataPoint(String label, boolean isOutput) {
        this.label = label;
        this.isOutput = isOutput;
    }
    protected void update(boolean isNewValue) {

    }
    public static DataPoint getDataPointFromLabel(String label) {
        return
    }
    public String getLabel() {
        return label;
    }
    public Boolean isOutput() {
        return isOutput;
    }

}

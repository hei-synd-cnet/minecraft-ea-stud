package ch.hevs.isi.core;
import java.util.HashMap;
import java.util.Map;

public abstract class DataPoint {
    protected static Map<String, DataPoint> dataPointMap = new HashMap<String, DataPoint>();

    protected String label;
    protected boolean isOutput;
    protected DataPoint(String label, boolean isOutput) {
        this.label = label;
        this.isOutput = isOutput;
    }
    protected void update(boolean isNewValue) {

    }
    public static DataPoint getDataPointFromLabel(String label) {
        return dataPointMap.get(label);
    }
    public String getLabel() {
        return label;
    }
    public Boolean isOutput() {
        return isOutput;
    }

}

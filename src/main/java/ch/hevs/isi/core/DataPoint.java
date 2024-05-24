package ch.hevs.isi.core;
import ch.hevs.isi.db.DatabaseConnector;
import ch.hevs.isi.field.FieldConnector;
import ch.hevs.isi.web.WebConnector;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class DataPoint {
    protected static Map<String, DataPoint> dataPointMap = new HashMap();

    protected String label;
    protected boolean isOutput;

    /**
     * Protected constructor
     */
    protected DataPoint(String label, boolean isOutput) {
        this.label = label;
        this.isOutput = isOutput;
        dataPointMap.put(label, this);
    }
    protected void update(boolean isNewValue) {
        WebConnector.getInstance().onNewValue(this);
        DatabaseConnector.getInstance().onNewValue(this);
        FieldConnector.getInstance().onNewValue(this);
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


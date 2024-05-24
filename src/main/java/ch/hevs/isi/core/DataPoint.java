package ch.hevs.isi.core;

import ch.hevs.isi.db.DataBaseConnector;
import ch.hevs.isi.field.FieldConnector;
import ch.hevs.isi.web.WebConnector;

import java.util.HashMap;
import java.util.Map;

public abstract class DataPoint {
    private static Map<String, DataPoint> dataPointMap = new HashMap<>();
    private String Label;
    private Boolean isOutput;

    protected DataPoint(String label, Boolean isOutput) {
        this.Label = label;
        this.isOutput = isOutput;
        dataPointMap.put(Label, this);
    }
    protected void update(boolean isNewValue){
        DataBaseConnector.getInstance().onNewValue(this);
        FieldConnector.getInstance().onNewValue(this);
        WebConnector.getInstance().onNewValue(this);
    }

    public static DataPoint getDataPointFromLabel(String Label) {
        return dataPointMap.get(Label);
    }
    public String getLabel(){
        return Label;
    }
    public Boolean isOutput(){
        return isOutput;
    }
}

package ch.hevs.isi.core;

import ch.hevs.isi.db.DataBaseConnector;
import ch.hevs.isi.field.FieldConnector;
import ch.hevs.isi.web.WebConnector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DataPoint {
    private static Map<String, DataPoint> dataPointMap = new HashMap<>();
    private String Label;
    private Boolean isOutput;
    private static final List<DataPointListener> dpListener = new ArrayList<>();

    protected DataPoint(String label, Boolean isOutput) {
        this.Label = label;
        this.isOutput = isOutput;
        dataPointMap.put(Label, this);
    }
    public static void subscribe(DataPointListener listener){
        dpListener.add(listener);

    };
    protected void update(boolean isNewValue){
        for(DataPointListener listener : dpListener){
            listener.onNewValue(this);
        }
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

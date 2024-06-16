package ch.hevs.isi.core;

import ch.hevs.isi.db.DataBaseConnector;
import ch.hevs.isi.field.FieldConnector;
import ch.hevs.isi.web.WebConnector;
import java.util.HashMap;
import java.util.Map;

public abstract class DataPoint {

    /**Attributes*/
    protected String label;
    static protected Map<String, DataPoint> dataPointMap = new HashMap<>();
    protected boolean isOutput; /**Indicates whether the DataPoint is an output or not*/

    /**Constructor*/
    public DataPoint(String label) {
        this.label = label;
        dataPointMap.put(label, this); /**Adds the DataPoint to the Map with its label as the key*/
        this.isOutput = false; /**Initializes isOutput to false by default*/
    }

    /**Methods*/
    public void update(boolean isNewValue){
        /**Notifies all connectors that a new value is available for this DataPoint*/
        DataBaseConnector.getInstance().oneNewValue(this);
        FieldConnector.getInstance().oneNewValue(this);
        WebConnector.getInstance().oneNewValue(this);
    }
    public static DataPoint getDataPointFromLabel(String label) {
        return dataPointMap.get(label);
    }
    public String getLabel() {
        return label;
    }

    /**Defines whether the DataPoint is an output or not*/
    public boolean isOutput() {
        return isOutput;
    }
}

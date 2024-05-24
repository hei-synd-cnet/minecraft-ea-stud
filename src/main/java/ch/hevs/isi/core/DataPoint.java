package ch.hevs.isi.core;

import ch.hevs.isi.db.DatabaseConnector;
import ch.hevs.isi.field.FieldConnector;
import ch.hevs.isi.web.WebConnector;

import java.util.List;
import java.lang.reflect.Field;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The abstract class DataPoint represents a generic data point.
 * It provides functionality to manage and interact with data points.
 */
public abstract class DataPoint {

    // Map to store data points by label
    protected static Map<String, DataPoint> dataPointMap = new HashMap();

    // Fields to store label and output status
    protected String label;
    protected boolean isOutput;

    // List to store registered DataPointListeners
    private static final List<DataPointListener> dpListenerList = new ArrayList<>();

    /**
     * Protected constructor to create a DataPoint instance.
     * @param label The label of the data point.
     * @param isOutput Indicates whether the data point is an output.
     */
    protected DataPoint(String label, boolean isOutput) {
        this.label = label;
        this.isOutput = isOutput;
        dataPointMap.put(label, this);
    }

    /**
     * Method to update the value of the data point.
     * Notifies WebConnector, DatabaseConnector, and FieldConnector about the new value.
     * @param isNewValue Indicates whether the value is new.
     */
    protected void update(boolean isNewValue) {
        WebConnector.getInstance().onNewValue(this);
        DatabaseConnector.getInstance().onNewValue(this);
        FieldConnector.getInstance().onNewValue(this);
    }

    /**
     * Method to retrieve a data point by its label.
     * @param label The label of the data point to retrieve.
     * @return The DataPoint instance corresponding to the label.
     */
    public static DataPoint getDataPointFromLabel(String label) {
        return dataPointMap.get(label);
    }

    /**
     * Method to get the label of the data point.
     * @return The label of the data point.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Method to check if the data point is an output.
     * @return True if the data point is an output, false otherwise.
     */
    public Boolean isOutput() {
        return isOutput;
    }

    /**
     * Method to subscribe to a DataPointListener.
     * @param listener The DataPointListener to subscribe.
     */
    public static void subscribe(DataPointListener listener){
        dpListenerList.add(listener);
    }

}
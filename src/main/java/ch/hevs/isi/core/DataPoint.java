package ch.hevs.isi.core;

import ch.hevs.isi.db.DataBaseConnector;
import ch.hevs.isi.field.FieldConnector;
import ch.hevs.isi.web.WebConnector;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class representing a data point in the system.
 */
public abstract class DataPoint {

    /** The label identifying the DataPoint. */
    protected String label;

    /** A map to store all DataPoints with their labels as keys. */
    static protected Map<String, DataPoint> dataPointMap = new HashMap<>();

    /** Indicates whether the DataPoint is an output or not. */
    protected boolean isOutput;

    /**
     * Constructs a DataPoint with the specified label.
     *
     * @param label the label of the DataPoint
     */
    public DataPoint(String label) {
        this.label = label;
        dataPointMap.put(label, this); /** Adds the DataPoint to the map with its label as the key */
        this.isOutput = false; /** Initializes isOutput to false by default */
    }

    /**
     * Notifies all connectors that a new value is available for this DataPoint.
     *
     * @param isNewValue a boolean indicating if the value is new
     */
    public void update(boolean isNewValue) {
        DataBaseConnector.getInstance().oneNewValue(this);
        FieldConnector.getInstance().oneNewValue(this);
        WebConnector.getInstance().oneNewValue(this);
    }

    /**
     * Retrieves a DataPoint from the map using its label.
     *
     * @param label the label of the DataPoint
     * @return the DataPoint associated with the given label
     */
    public static DataPoint getDataPointFromLabel(String label) {
        return dataPointMap.get(label);
    }

    /**
     * Gets the label of the DataPoint.
     *
     * @return the label of the DataPoint
     */
    public String getLabel() {
        return label;
    }

    /**
     * Checks if the DataPoint is an output.
     *
     * @return true if the DataPoint is an output, false otherwise
     */
    public boolean isOutput() {
        return isOutput;
    }
}
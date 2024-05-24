package ch.hevs.isi.core;

import ch.hevs.isi.db.DataBaseConnector;
import ch.hevs.isi.field.FieldConnector;
import ch.hevs.isi.web.WebConnector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DataPoint {
    /**
     * Hashmap of the all datapoint that we use
     */
    private static Map<String, DataPoint> dataPointMap = new HashMap<>();
    private String Label;
    private Boolean isOutput;
    /**
     * List of all the subscriber of our datapoint
     */
    private static final List<DataPointListener> dpListener = new ArrayList<>();

    /**
     * Constructor of the datapoint
     * @param label Name of the datapoint
     * @param isOutput
     */
    protected DataPoint(String label, Boolean isOutput) {
        this.Label = label;
        this.isOutput = isOutput;
        dataPointMap.put(Label, this);
    }

    /**
     * Allow the datapoint listener to sub to the list
     * @param listener
     */
    public static void subscribe(DataPointListener listener){
        dpListener.add(listener);

    };

    /**
     * Send the new value to each new listener
     * @param isNewValue
     */
    protected void update(boolean isNewValue){
        for(DataPointListener listener : dpListener){
            listener.onNewValue(this);
        }
    }

    /**
     * We can get the datapoint that we want from his label
     * @param Label
     * @return
     */
    public static DataPoint getDataPointFromLabel(String Label) {
        return dataPointMap.get(Label);
    }

    /**
     * Get the label of the datapoint
     * @return
     */
    public String getLabel(){
        return Label;
    }

    /**
     * Return if the datapoint is an output or not
     * @return
     */
    public Boolean isOutput(){
        return isOutput;
    }
}

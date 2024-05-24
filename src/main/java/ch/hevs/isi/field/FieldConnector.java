package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;
import ch.hevs.isi.db.DataBaseConnector;
/**
 * Class to link field
 */
public class FieldConnector implements DataPointListener {
    private static FieldConnector fieldCo = null;
    /**
     * Private constructor
     * We also sub to the datapoint listener list when it is instantiated
     */
    private FieldConnector() {
        DataPoint.subscribe(this);
    };
    /**
     *The static method getInstance() returns a reference to the singleton.
     * It creates the single object if it does not exist (lazy).
     *
     */
    public static FieldConnector getInstance() {
        if (fieldCo == null) {
            fieldCo = new FieldConnector();
        }
        return fieldCo;
    }

    /**
     * Initialize the connector
     * @param host
     * @param port
     */
    public void initialize (String host,int port){

    }

    /** Push the datapoint to the field
     * @param dp datapoint to push the field
     */
    private void pushToField(DataPoint dp){
        System.out.println("PushToField");
    }

    /**
     * When we have a new value from the datapoint
     * @param dp
     */
    @Override
    public void onNewValue(DataPoint dp) {
        pushToField(dp);
    }
}

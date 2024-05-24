package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;

public class FieldConnector implements DataPointListener {
    /**
     * This variable creates a unique instance, later taken as attribute
     */
    private static FieldConnector instance = null;

    /**
     * private constructor
     */
    private FieldConnector(){}

    /**
     * The static method getInstance() returns a reference to the singleton.
     * It creates the single FieldConnector object if it does not exist (lazy).
     * @return the only instance of the FieldConnector
     */
    public static FieldConnector getInstance(){
        if (instance == null) {
            instance = new FieldConnector();
        }
        return instance;
    }
    public void initialize(String url){     //A compléter

    }
    private void pushToField(DataPoint dp){
        System.out.println("Pushing to Field: " + dp);
    }

    @Override
    public void onNewValue(DataPoint dp) {
        pushToField(dp);
    }
}

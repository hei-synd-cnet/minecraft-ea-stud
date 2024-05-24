package ch.hevs.isi.web;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;

public class WebConnector implements DataPointListener {
    /**
     * This variable creates a unique instance, later taken as attribute
     */
    private static WebConnector instance = null;

    /**
     * Private constructor
     */
    private WebConnector(){}

    /**
     * The static method getInstance() returns a reference to the singleton.
     * It creates the single WebConnector object if it does not exist (lazy).
     * @return the only instance of the WebConnector
     */
    public static WebConnector getInstance(){
        if (instance == null) {
            instance = new WebConnector();
        }
        return instance;
    }
    public void initialize(String url){     //A compléter

    }
    private void pushToWeb(DataPoint dp){
        System.out.println("Pushing to Web: " + dp);
    }

    @Override
    public void onNewValue(DataPoint dp) {
        pushToWeb(dp);
    }
}

package ch.hevs.isi.web;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;

public class WebConnector implements DataPointListener {
    private static WebConnector webCo = null;
    /**
     * Private constructor
     * We also sub to the datapoint listener list when it is instantiated
     */
    private WebConnector(){
        DataPoint.subscribe(this);
    };
    /**
     *The static method getInstance() returns a reference to the singleton.
     * It creates the single object if it does not exist (lazy).
     *
     */
    public static WebConnector getInstance(){
        if (webCo == null){
            webCo = new WebConnector();
        }
        return webCo;
    }
    /**
     * Initialize the connector
     * @param host
     * @param port
     */
    public void initialize(String host,int port){
        //
    }
    /** Push the datapoint to the field
     * @param dp datapoint to push the field
     */
    private void pushToWeb(DataPoint dp){
        System.out.println("Push to web");
    }
    /**
     * When we have a new value from the datapoint
     * @param dp
     */
    @Override
    public void onNewValue(DataPoint dp) {
        pushToWeb(dp);
    }
}

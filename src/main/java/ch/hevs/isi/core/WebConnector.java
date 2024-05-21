package ch.hevs.isi.core;

public class WebConnector {
    // Private and unique instance as attribute
    private static WebConnector instance = null;

    // Private constructor
    private WebConnector(){}

    // The static method getInstance() returns a reference to the singleton.
    // It creates the single X_Connector object if it does not exist (lazy).
    public WebConnector getInstance(){
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
}

package ch.hevs.isi.core;

class FieldConnector implements DataPointListener {
    // Private and unique instance as attribute
    private static FieldConnector instance = null;

    // Private constructor
    private FieldConnector(){}

    // The static method getInstance() returns a reference to the singleton.
    // It creates the single X_Connector object if it does not exist (lazy).
    public FieldConnector getInstance(){
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

    }
}

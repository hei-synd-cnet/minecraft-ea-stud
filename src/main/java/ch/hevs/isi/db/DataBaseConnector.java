package ch.hevs.isi.db;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;

public class DataBaseConnector implements DataPointListener {
    private static DataBaseConnector datBaseCo = null;
    // Private constructor
    private DataBaseConnector() {
        DataPoint.subscribe(this);
    };
    // The static method getInstance() returns a reference to the singleton.
// It creates the single X_Connector object if it does not exist (lazy).
    public static DataBaseConnector getInstance() {
        if (datBaseCo == null) {
            datBaseCo = new DataBaseConnector();
        }
        return datBaseCo;
    }
    public void initialize (String host,int port){

    }
    private void pushToDataBase(DataPoint dp){
        System.out.println("PushToDatabase");
    }

    @Override
    public void onNewValue(DataPoint dp) {
        pushToDataBase(dp);
    }
}

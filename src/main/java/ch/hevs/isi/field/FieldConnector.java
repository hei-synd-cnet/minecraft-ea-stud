package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.db.DataBaseConnector;

public class FieldConnector {
    private static FieldConnector fieldCo = null;
    // Private constructor
    private FieldConnector() {};
    // The static method getInstance() returns a reference to the singleton.
// It creates the single X_Connector object if it does not exist (lazy).
    public static FieldConnector getInstance() {
        if (fieldCo == null) {
            fieldCo = new FieldConnector();
        }
        return fieldCo;
    }
    public void initialize (String host,int port){

    }
    private void pushToField(DataPoint dp){
        System.out.println("PushToField");
    }
}

package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;

public class FieldConnector implements DataPointListener {

    //Attribut / instance
    private static FieldConnector f_c = null;

    // Private constructor
    private FieldConnector() {};

    //Méthodes
    public FieldConnector getInstance() {
        if (f_c == null) {
            f_c = new FieldConnector();
        }
        return f_c;
    }
    public void initialize (String host, int port){
    }
    private void pushToField(DataPoint dp){
    }

}

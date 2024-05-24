package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;

public class FieldConnector implements DataPointListener {

    /**Attributes*/
    private static FieldConnector f_c = null;

    /**Private constructor*/
    private FieldConnector() {};

    /**Methods*/
    public static FieldConnector getInstance() {
        if (f_c == null) {
            f_c = new FieldConnector();
        }
        return f_c;
    }
    public void initialize (String host, int port){
    }
    private void pushToField(DataPoint dp){
        System.out.println("Push to Field");
    }

    @Override
    public void oneNewValue(DataPoint dp) {
        pushToField(dp);
    }
}

package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;
public class FieldConnector implements DataPointListener{
    private static FieldConnector instance = null;
    private FieldConnector(){};

    public static FieldConnector getInstance()
    {
        if (instance == null){
            instance = new FieldConnector();
        }
        return instance;
    }


    //public void initialize(String url,...){}
    private void pushToDatabase(DataPoint dp) {
        System.out.println("Push Field: " + dp);
    }

    @Override
    public void onNewValue(DataPoint dp) {
        pushToDatabase(dp);
    }
}

package ch.hevs.isi.db;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;
import ch.hevs.isi.field.FieldConnector;

public class DataBaseConnector implements DataPointListener {


    /**Private and unique instance as attribute*/
    protected static DataBaseConnector db_c = null;

    /**Private Constructor*/
   private  DataBaseConnector() {};

    /**Methods*/
    public static DataBaseConnector getInstance () {
        if (db_c == null) {
            db_c = new DataBaseConnector();
        }
        return db_c;
    }
    public void initialize(String url){
    }
    private void pushToDatabase (DataPoint dp){
        System.out.println("Push to Data Base");
    }

    @Override
    public void oneNewValue(DataPoint dp) {
        pushToDatabase(dp);
    }
}


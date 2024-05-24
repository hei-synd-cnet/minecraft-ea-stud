package ch.hevs.isi.db;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;


/**
 * Class to link field and dataBase
 */
public class DataBaseConnector implements DataPointListener {
    private static DataBaseConnector datBaseCo = null;

    /**
     * Constructor
     * Subscribe the dataBaseConnector to the Datapoint when it's create
     */
    private DataBaseConnector() {
        DataPoint.subscribe(this);
    };

    /**
     * The static method getInstance() returns a reference to the singleton.
     * It creates the single object if it does not exist (lazy)
     * @return
     */

    public static DataBaseConnector getInstance() {
        if (datBaseCo == null) {
            datBaseCo = new DataBaseConnector();
        }
        return datBaseCo;
    }

    /**
     * initialize the connector
     * @param host
     * @param port
     */
    public void initialize (String host,int port){

    }

    /**
     * Send data to database
     * @param dp
     */
    private void pushToDataBase(DataPoint dp){
        System.out.println("PushToDatabase");
    }

    /**
     *
     * @param dp call method pushToDataBase and pass the dp in parameter
     */
    @Override
    public void onNewValue(DataPoint dp) {
        pushToDataBase(dp);
    }
}

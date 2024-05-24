package ch.hevs.isi.db;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;

/**
 * The DatabaseConnector class is responsible for connecting to a database and pushing data points to it.
 * It implements the DataPointListener interface to listen for new data points.
 */
public class DatabaseConnector implements DataPointListener {

    /**
     * This variable creates a unique instance, later taken as attribute
     */
    private static DatabaseConnector instance = null;

    /**
     * Private constructor to prevent external instantiation.
     * It subscribes the DatabaseConnector instance to receive data point updates.
     */
    private DatabaseConnector(){
        DataPoint.subscribe(this);
    }

    /**
     * The static method getInstance() returns a reference to the singleton.
     * It creates the single DatabaseConnector object if it does not exist (lazy initialization).
     * @return the only instance of the DatabaseConnector
     */
    public static DatabaseConnector getInstance(){
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }

    /**
     * Method to initialize the database connection.
     * @param url The URL of the database.
     */
    public void initialize(String url){
        // To be implemented
    }

    /**
     * Method to push a data point to the database.
     * @param dp The data point to be pushed.
     */
    private void pushToDatabase(DataPoint dp){
        System.out.println("Pushing to Database: " + dp);
    }

    /**
     * Method called when a new value is received from a data point.
     * It pushes the data point to the database.
     * @param dp The data point with the new value.
     */
    @Override
    public void onNewValue(DataPoint dp) {
        pushToDatabase(dp);
    }
}
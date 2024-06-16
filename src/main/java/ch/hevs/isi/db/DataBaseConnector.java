package ch.hevs.isi.db;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Singleton class responsible for connecting and interacting with the database.
 * Implements DataPointListener to receive updates from DataPoints.
 */
public class DataBaseConnector implements DataPointListener {

    /** Singleton instance of DataBaseConnector. */
    protected static DataBaseConnector db_c = null;

    /** The protocol used to connect to the database. */
    private String dbProtocol;

    /** The hostname of the database. */
    private String dbHostName;

    /** The database bucket name. */
    private String dbBucket;

    /** The authentication token for accessing the database. */
    private String dbToken;

    /** Private constructor to enforce singleton pattern. */
    private DataBaseConnector() {
    }

    /**
     * Retrieves the singleton instance of DataBaseConnector.
     *
     * @return the singleton instance of DataBaseConnector
     */
    public static DataBaseConnector getInstance() {
        if (db_c == null) {
            db_c = new DataBaseConnector();
        }
        return db_c;
    }

    /**
     * Initializes the DataBaseConnector with the specified database parameters.
     *
     * @param dbProtocol the protocol used to connect to the database (e.g., "http" or "https")
     * @param dbHostname the hostname of the database server
     * @param dbBucket the name of the database bucket
     * @param dbToken the authentication token for accessing the database
     */
    public void initialize(String dbProtocol, String dbHostname, String dbBucket, String dbToken) {
        this.dbProtocol = dbProtocol;
        this.dbHostName = dbHostname;
        this.dbBucket = dbBucket;
        this.dbToken = dbToken;
    }

    /**
     * Pushes the new value of a DataPoint to the database.
     *
     * @param dp the DataPoint with a new value to push to the database
     */
    private void pushToDatabase(DataPoint dp) {
        //System.out.println("Push to Data Base");
        String msg = "Minecraft " + dp.getLabel() + "=" + dp.toString();
        try {
            // Construct a URL object
            URL url = new URL(dbProtocol + "://" + dbHostName + "/api/v2/write?org=" + dbBucket + "&bucket=" + dbBucket);

            // Invoke the URL object’s openConnection() method to retrieve an HttpURLConnection object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configure the HttpURLConnection:
            connection.setRequestProperty("Authorization", "Token " + dbToken);
            connection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Fetch an OutputStreamWriter object for the HttpURLConnection:
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

            // Write the body of the HTTP Post request into the OutputStreamWriter:
            writer.write(msg);
            writer.flush();

            // Wait for the response and check that its status code is “204” and read incoming data
            int responseCode = connection.getResponseCode();
            if (responseCode == 204) {
                String response = connection.getResponseMessage();
                //System.out.println(response);
            }

            // Close all communication related objects
            connection.disconnect();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Callback method invoked when a new value is available for a DataPoint.
     *
     * @param dp the DataPoint with a new value
     */
    @Override
    public void oneNewValue(DataPoint dp) {
        pushToDatabase(dp);
    }
}


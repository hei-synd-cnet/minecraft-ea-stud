package ch.hevs.isi.db;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;
import ch.hevs.isi.field.FieldConnector;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class DataBaseConnector implements DataPointListener {


    /**Private instance as attribute*/
    protected static DataBaseConnector db_c = null;
    private String dbProtocol;
    private String dbHostName;
    private String dbBucket;
    private String dbToken;


    /**Private Constructor*/
   private  DataBaseConnector() {};

    /**Methods*/
    public static DataBaseConnector getInstance () {
        if (db_c == null) {
            db_c = new DataBaseConnector();
        }
        return db_c;
    }

    public void initialize(String dbProtocol, String dbHostname, String dbBucket, String dbToken){
        this.dbProtocol = dbProtocol;
        this.dbHostName = dbHostname;
        this.dbBucket = dbBucket;
        /**My Token : 9RuuXGkejzP1akpkdNOkJx7J3OL-uix_XsTxDSrhYb-qnJoMHP3358llOSA2V96pIO8UuO8qng6-XHg0T93kuA== */
        this.dbToken = dbToken;

    }
    private void pushToDatabase (DataPoint dp){
        System.out.println("Push to Data Base");
        String msg = "Minecraft " + dp.getLabel() + "=" + dp.toString();
        try {
            /**Construct a URL object*/
            URL url = new URL(dbProtocol+"://"+dbHostName+"/api/v2/write?org="+dbBucket+"&bucket="+dbBucket);

            /**Invoke the URL object’s openConnection() method to retrieve an HttpURLConnection object*/
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            /**Configure the HttpURLConnection:*/
            connection.setRequestProperty("Authorization", "Token " + dbToken);
            connection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            /**Fetch an OutputStreamWriter object for the HttpURLConnection:*/
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

            /**Write the body of the HTTP Post request into the OutputStreamWriter:*/
            writer.write(msg);
            writer.flush();

            /**Wait for the response and check that its status code is “204” and read incoming data*/
            int responseCode = connection.getResponseCode();
            if(responseCode == 204){
                String response = connection.getResponseMessage();
                System.out.println(response);
            }
            /**Close all communication related objects*/
            connection.disconnect();
        }
        catch (IOException e ) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void oneNewValue(DataPoint dp) {
        pushToDatabase(dp);
    }
}


package ch.hevs.isi.db;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Class to link field and dataBase
 */
public class DataBaseConnector implements DataPointListener {
    private static DataBaseConnector datBaseCo = null;
    private String dbProtocol;
    private String dbHostName;
    private String dbBucket;
    private String dbToken;

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
     *
     * @param dbProtocol
     * @param dbHostName
     * @param dbBucket
     * @param dbToken
     */
    public void initialize (String dbProtocol, String dbHostName, String dbBucket, String dbToken){
        this.dbProtocol=dbProtocol;
        this.dbHostName=dbHostName;
        this.dbBucket=dbBucket;
        this.dbToken=dbToken; //n2hnjQ12N6zSUaEMdJhZmLq_ss7wY7bTnNcfwyek91OAGQ7HNvIj5FGfNZTxZXJoDXLcCG2xcMf-zxPCoQj9sA==
    }

    /**
     * Send data to database
     * @param dp
     */
    private void pushToDataBase(DataPoint dp){
        String msg= "Minecraft " + dp.getLabel() +"=" + dp.toString(); //Message for
        try {
            URL url = new URL(dbProtocol+"://"+dbHostName+"/api/v2/write?org="+dbBucket+"&bucket="+dbBucket);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty ("Authorization", "Token " + dbToken);
            connection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(msg);
            writer.flush();
            int responseCode = connection.getResponseCode();
            if (responseCode == 204){
                String response = connection.getResponseMessage();
                System.out.println(response);

            }
            connection.disconnect();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);

        }






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

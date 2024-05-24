package ch.hevs.isi.web;
import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;
public class WebConnector implements DataPointListener{
    private static WebConnector instance = null;
    private WebConnector(){};

    public static WebConnector getInstance()
    {
        if (instance == null){
            instance = new WebConnector();
        }
        return instance;
    }


    //public void initialize(String url,...){}
    private void pushToDatabase(DataPoint dp) {
        System.out.println("Push Web: " + dp);
    }

    @Override
    public void onNewValue(DataPoint dp) {
        pushToDatabase(dp);
    }
}

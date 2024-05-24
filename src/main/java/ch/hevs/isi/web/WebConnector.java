package ch.hevs.isi.web;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;

public class WebConnector implements DataPointListener {
    private static WebConnector webCo = null;
    private WebConnector(){};

    public static WebConnector getInstance(){
        if (webCo == null){
            webCo = new WebConnector();
        }
        return webCo;
    }
    public void initialize(String host,int port){
        //
    }

    private void pushToWeb(DataPoint dp){
        System.out.println("Push to web");
    }

    @Override
    public void onNewValue(DataPoint dp) {
        pushToWeb(dp);
    }
}

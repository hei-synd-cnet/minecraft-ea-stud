package ch.hevs.isi.web;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;
import ch.hevs.isi.field.FieldConnector;
public class WebConnector implements DataPointListener {

    /**Attributes*/
    private static WebConnector w_c = null;

    /**Private constructor*/
    private WebConnector() {};

    /**Methods*/
    public static WebConnector getInstance (){
        if (w_c == null) {
            w_c = new WebConnector();
        }
        return w_c;
    }
    public void initialize (String host, int port){
    }
    private void pushToWeb(DataPoint dp){
        System.out.println("Push to Web");
    }

    @Override
    public void oneNewValue(DataPoint dp) {
        pushToWeb(dp);
    }
}

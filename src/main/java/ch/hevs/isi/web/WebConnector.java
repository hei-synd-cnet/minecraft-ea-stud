package ch.hevs.isi.web;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;
import ch.hevs.isi.field.FieldConnector;
public class WebConnector implements DataPointListener {

    //Attribut
    private static WebConnector w_c = null;

    // Private constructor
    private WebConnector() {};

    public WebConnector getInstance (){
        return w_c;
    }
    public void initialize (String host, int port){
    }
    private void pushToWeb(DataPoint dp){
    }
}

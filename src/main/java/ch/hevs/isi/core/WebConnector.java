package ch.hevs.isi.core;

public class WebConnector {
    private static WebConnector instance;
    private WebConnector(){

    }
    public WebConnector getInstance(){
        //A compléter
    }
    public void initialize(String url){     //A compléter

    }
    private void pushToWeb(DataPoint dp){
        System.out.println("Pushing to Web: " + dp);
    }
}

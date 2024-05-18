package ch.hevs.isi.core;

class FieldConnector {
    private static FieldConnector instance;
    private FieldConnector(){

    }
    public FieldConnector getInstance(){
        //A compléter
    }
    public void initialize(String url){     //A compléter

    }
    private void pushToField(DataPoint dp){
        System.out.println("Pushing to Field: " + dp);
    }
}

package ch.hevs.isi.core;

class DatabaseConnector {
    private static DatabaseConnector instance;
    private DatabaseConnector(){

    }
    public DatabaseConnector getInstance(){
        //A compléter
    }
    public void initialize(String url){     //A compléter

    }
    private void pushToDatabase(DataPoint dp){
        System.out.println("Pushing to Database: " + dp);
    }
}

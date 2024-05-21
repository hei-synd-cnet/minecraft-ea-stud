package ch.hevs.isi.db;

import ch.hevs.isi.core.DataPoint;

public class DataBaseConnector {
    private static DataBaseConnector instance = null;
    private DataBaseConnector(){};

    public static DataBaseConnector getInstance()
    {
        if (instance == null){
            instance = new DataBaseConnector();
        }
        return instance;
    }

    //public void initialize(String url, ...){}
    //private pushToDatabase(DataPoint dp);
}

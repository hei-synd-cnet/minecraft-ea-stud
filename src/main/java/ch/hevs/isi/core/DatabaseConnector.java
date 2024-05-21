package ch.hevs.isi.core;

class DatabaseConnector {
    /**
     * This variable creates a unique instance, later taken as attribute
     */
    private static DatabaseConnector instance = null;

    /**
     * private constructor
     */
    private DatabaseConnector(){
    }

    /**
     * The static method getInstance() returns a reference to the singleton.
     * It creates the single X_Connector object if it does not exist (lazy).
     * @return : the only instance of the DatabaseConnector
     */
    public DatabaseConnector getInstance(){
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }
    public void initialize(String url){     //A compléter

    }
    private void pushToDatabase(DataPoint dp){
        System.out.println("Pushing to Database: " + dp);
    }
}

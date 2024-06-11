package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;
import ch.hevs.isi.field.ModbusRegister;

/**
 * The FieldConnector class is responsible for connecting to a field and receiving data points from it.
 * It implements the DataPointListener interface to listen for new data points.
 */
public class FieldConnector implements DataPointListener {

    /**
     * This variable creates a unique instance, later taken as attribute
     */
    private static FieldConnector instance = null;
    private ModbusRegister register;

    /**
     * Private constructor to prevent external instantiation.
     * It subscribes the FieldConnector instance to receive data point updates.
     */
    private FieldConnector(){
        DataPoint.subscribe(this);
    }

    /**
     * The static method getInstance() returns a reference to the singleton.
     * It creates the single FieldConnector object if it does not exist (lazy initialization).
     * @return the only instance of the FieldConnector
     */
    public static FieldConnector getInstance(){
        if (instance == null) {
            instance = new FieldConnector();
        }
        return instance;
    }

    /**
     * Method to initialize the connection to the field.
     * @param ipAdress The URL of the field.
     * @param port ...
     */
    public static void initialize(String ipAdress, int port){
        ModbusAccessor.create();
        ModbusAccessor.connect(ipAdress,port);
    }

    /**
     * Method to push a data point to the field.
     * @param dp The data point to be pushed.
     */
    private void pushToField(DataPoint dp){

        System.out.println("Pushing to Field: " + dp);

    }

    /**
     * Method called when a new value is received from a data point.
     * It pushes the data point to the field.
     * @param dp The data point with the new value.
     */
    @Override
    public void onNewValue(DataPoint dp) {
        register = ModbusRegister.getRegisterFromDataPoint(dp);
        System.out.println(register);
        if (register != null) {
            register.write();
        }
        pushToField(dp);
    }
}
package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;

/**
 * Singleton class responsible for connecting and interacting with field devices.
 * Implements DataPointListener to receive updates from DataPoints.
 */
public class FieldConnector implements DataPointListener {

    /**
     * Singleton instance of FieldConnector.
     */
    private static FieldConnector f_c = null;

    /**
     * Private constructor to enforce singleton pattern.
     */
    private FieldConnector() {
    }

    /**
     * Retrieves the singleton instance of FieldConnector.
     *
     * @return the singleton instance of FieldConnector
     */
    public static FieldConnector getInstance() {
        if (f_c == null) {
            f_c = new FieldConnector();
        }
        return f_c;
    }

    /**
     * Initializes the FieldConnector with the specified host and port.
     *
     * @param host the host address of the field device
     * @param port the port number of the field device
     */
    public void initialize(String host, int port) {
        // Initialize the connector
        ModbusAccessor.getInstance(host, port, 1);
    }

    /**
     * Pushes the new value of a DataPoint to the connected field device.
     *
     * @param dp the DataPoint with a new value
     */
    private void pushToField(DataPoint dp) {
        //System.out.println("Push to Field");
        if (dp.isOutput()) {
            ModbusRegister mr = ModbusRegister.getRegisterFromDataPoint(dp);
            mr.write();
        }
    }

    /**
     * Callback method invoked when a new value is available for a DataPoint.
     *
     * @param dp the DataPoint with a new value
     */
    @Override
    public void oneNewValue(DataPoint dp) {
        pushToField(dp);
    }

}



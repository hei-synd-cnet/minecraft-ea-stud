package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;


public class FieldConnector implements DataPointListener {
    /**
     * Attributes
     */
    private static FieldConnector f_c = null;

    /**
     * Private constructor
     */
    private FieldConnector() {
    }

    /**
     * Methods
     */
    public static FieldConnector getInstance() {
        if (f_c == null) {
            f_c = new FieldConnector();
        }
        return f_c;
    }

    public void initialize(String host, int port) {
        // Initialize the connector
        ModbusAccessor.getInstance(host, port, 1);
    }

    private void pushToField(DataPoint dp) {
        //System.out.println("Push to Field");
        if (dp.isOutput()) {
            ModbusRegister mr = ModbusRegister.getRegisterFromDataPoint(dp);
            mr.write();
        }
    }
    @Override
    public void oneNewValue(DataPoint dp) {
        pushToField(dp);
    }

}



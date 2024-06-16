package ch.hevs.isi.field;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;

/**
 * Singleton class for accessing and interacting with Modbus registers.
 */
public class ModbusAccessor {

    /** Singleton instance of ModbusAccessor. */
    private static ModbusAccessor instance = null;

    /** The ModbusMaster for communication. */
    private ModbusMaster modbusMaster;

    /** The slave ID for the Modbus device. */
    private int slaveId;

    /**
     * Gets the singleton instance of ModbusAccessor, initializing it if necessary.
     *
     * @param ip the IP address of the Modbus device
     * @param port the port number of the Modbus device
     * @param slaveId the slave ID of the Modbus device
     * @return the singleton instance of ModbusAccessor
     */
    public static ModbusAccessor getInstance(String ip, int port, int slaveId) {
        if (instance == null) {
            instance = new ModbusAccessor(ip, port, slaveId);
        }
        return instance;
    }

    /**
     * Gets the singleton instance of ModbusAccessor. Must be called after the
     * instance has been initialized with the parameters.
     *
     * @return the singleton instance of ModbusAccessor
     */
    public static ModbusAccessor getInstance() {
        if (instance == null) {
            System.err.println("You should use first ModbusAccessor.getInstance(String ip, int port, int slaveId)");
            System.exit(-1);
        }
        return instance;
    }

    /**
     * Private constructor to initialize ModbusAccessor with the specified parameters.
     *
     * @param ip the IP address of the Modbus device
     * @param port the port number of the Modbus device
     * @param slaveId the slave ID of the Modbus device
     */
    private ModbusAccessor(String ip, int port, int slaveId) {
        this.slaveId = slaveId;
        IpParameters params = new IpParameters();
        params.setHost(ip);
        params.setPort(port);

        ModbusFactory modbusFactory = new ModbusFactory();
        modbusMaster = modbusFactory.createTcpMaster(params, true);

        try {
            modbusMaster.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads a boolean value from the specified Modbus address.
     *
     * @param address the address to read from
     * @return the boolean value at the specified address
     */
    public boolean readBoolean(int address) {
        try {
            BaseLocator<Boolean> locator = BaseLocator.coilStatus(slaveId, address);
            return modbusMaster.getValue(locator);
        } catch (ModbusTransportException e) {
            e.printStackTrace();
            return false;
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads a float value from the specified Modbus address.
     *
     * @param address the address to read from
     * @return the float value at the specified address
     */
    public float readFloat(int address) {
        try {
            BaseLocator<Number> locator = BaseLocator.holdingRegister(slaveId, address, DataType.FOUR_BYTE_FLOAT);
            return modbusMaster.getValue(locator).floatValue();
        } catch (ModbusTransportException e) {
            e.printStackTrace();
            return -1.0f;
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes a float value to the specified Modbus address.
     *
     * @param address the address to write to
     * @param value the float value to write
     */
    public void writeFloat(int address, float value) {
        try {
            BaseLocator<Number> locator = BaseLocator.holdingRegister(slaveId, address, DataType.FOUR_BYTE_FLOAT);
            modbusMaster.setValue(locator, value);
        } catch (ModbusTransportException e) {
            e.printStackTrace();
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes a boolean value to the specified Modbus address.
     *
     * @param address the address to write to
     * @param value the boolean value to write
     */
    public void writeBoolean(int address, boolean value) {
        try {
            BaseLocator<Boolean> locator = BaseLocator.coilStatus(slaveId, address);
            modbusMaster.setValue(locator, value);
        } catch (ModbusTransportException e) {
            e.printStackTrace();
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        }
    }
}

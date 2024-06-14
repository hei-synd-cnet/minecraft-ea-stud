package ch.hevs.isi.field;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;


public class ModbusAccessor {
    private static ModbusAccessor instance = null;
    private ModbusMaster modbusMaster;
    private int slaveId;

    public static  ModbusAccessor getInstance(String ip, int port, int slaveId) {
        if (instance == null) {
            instance = new ModbusAccessor(ip, port, slaveId);
        }
        return instance;
    }
    public static ModbusAccessor getInstance() {
        if (instance == null) {
            System.out.println("ModbusAccessor not initialized yet");
            return null;
        }
        return instance;
    }

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

    public void disconnect() {
        modbusMaster.destroy();
    }

}
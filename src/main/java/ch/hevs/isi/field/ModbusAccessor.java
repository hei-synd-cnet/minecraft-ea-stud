package ch.hevs.isi.field;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.msg.*;


public class ModbusAccessor {
    private ModbusMaster master;
    private String ip;
    private int port;

    public void ModbusAccessor(ModbusMaster master, String ip, int port) {
        this.master = master;
        this.ip = ip;
        this.port = port;
    }

    public void connect(String ip, int port) throws ModbusInitException {
        IpParameters params = new IpParameters();
        params.setHost(ip);
        params.setPort(port);

        ModbusFactory modbusFactory = new ModbusFactory();
        master = modbusFactory.createTcpMaster(params, true);
        master.init();
    }

    public boolean readBoolean(int slaveId, int startOffset, int regAdd) throws ModbusTransportException{
        ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(slaveId, startOffset, regAdd);
        ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master.send(request);
        return response.getBooleanData()[0];
    }

    public void writeBoolean(int regAddress, boolean value, int startOffset) throws ModbusTransportException {
        WriteCoilRequest request = new WriteCoilRequest(regAddress,startOffset, value);
        master.send(request);
    }

    public float readFloat(int slaveId, int startOffset, int regAdd) throws ModbusTransportException {
        ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(slaveId, startOffset, regAdd);
        ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master.send(request);
        short[] data = response.getShortData();
        return Float.intBitsToFloat((data[1] << 16) | (data[0] & 0xFFFF));
    }

    public void writeFloat(int regAddress, float value, int writeOffset) throws ModbusTransportException {
        int intBits = Float.floatToIntBits(value);
        int high = (intBits >> 16) & 0xFFFF;
        int low = intBits & 0xFFFF;
        master.send(new WriteRegisterRequest(regAddress,writeOffset, low));
        master.send(new WriteRegisterRequest(regAddress + 1,writeOffset, high));
    }

}

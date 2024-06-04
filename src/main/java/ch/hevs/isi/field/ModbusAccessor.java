package ch.hevs.isi.field;
import ch.hevs.isi.core.DataPoint;
import com.serotonin.modbus4j.*;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;
import org.apache.commons.lang3.ObjectUtils;

import javax.xml.crypto.Data;

public class ModbusAccessor {
    private static ModbusAccessor instance = null;
    private static ModbusMaster master = null;
    public static IpParameters params = new IpParameters();
    private ModbusAccessor(){}
    public static ModbusAccessor create(){
        if (instance == null) {
            instance = new ModbusAccessor();
        }
        return instance;
    }
    public static void connect(String ipAdress, int port){
        params.setHost(ipAdress);
        params.setPort(port);
        master = new ModbusFactory().createTcpMaster(params,true);
        try {
            master.init();
        } catch (ModbusInitException e) {
            System.err.println("ModbusInitException" + e.getMessage());
        }
    }
    public static Boolean readBoolean(int regAdress){
        try {
            return master.getValue(BaseLocator.coilStatus(1,regAdress));
        } catch (ModbusTransportException e) {
            System.err.println("ModbusTransportException: " + e.getMessage());
        } catch (ErrorResponseException e) {
            System.err.println("ErrorResponseException: " + e.getMessage());
        }
        return null;

    }
    public static Number readFloat(int regAdress){
        try {
            return master.getValue(BaseLocator.holdingRegister(1,regAdress, DataType.FOUR_BYTE_FLOAT));
        } catch (ModbusTransportException e) {
            System.err.println("ModbusTransportException: " + e.getMessage());
        } catch (ErrorResponseException e) {
            System.err.println("ErrorResponseException: " + e.getMessage());
        }
        return null;
    }
    public static void writeBoolean(int regAdress, boolean newValue){
        try {
            master.setValue(BaseLocator.coilStatus(1,regAdress), newValue);
        } catch (ModbusTransportException e) {
            System.err.println("ModbusTransportException: " + e.getMessage());
        } catch (ErrorResponseException e) {
            System.err.println("ErrorResponseException: " + e.getMessage());
        }
    }
    public static void writeFloat(int regAdress, float newValue){
        try {
            master.setValue(BaseLocator.holdingRegister(1,regAdress, DataType.FOUR_BYTE_FLOAT), newValue);
        } catch (ModbusTransportException e) {
            System.err.println("ModbusTransportException: " + e.getMessage());
        } catch (ErrorResponseException e) {
            System.err.println("ErrorResponseException: " + e.getMessage());
        }
    }

}
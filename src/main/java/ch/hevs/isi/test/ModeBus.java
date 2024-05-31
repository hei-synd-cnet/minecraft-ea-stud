package ch.hevs.isi.test;

import ch.hevs.isi.field.ModbusAccessor;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;

public class ModeBus {
    public static void main(String[] args) throws ModbusInitException, ModbusTransportException {
        ModbusAccessor modbus = new ModbusAccessor();
        modbus.connect("127.0.0.1", 502);

        // Test lettura/scrittura boolean
        modbus.writeBoolean(97, true, 0);
        boolean boolValue = modbus.readBoolean(98, 0, 54);
        System.out.println("Boolean value: " + boolValue);
    }
}

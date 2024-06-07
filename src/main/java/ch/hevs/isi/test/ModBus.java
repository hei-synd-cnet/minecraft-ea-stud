package ch.hevs.isi.test;

import ch.hevs.isi.field.BooleanRegister;
import ch.hevs.isi.field.ModbusAccessor;

public class ModBus {
    public static void main(String[] args) {
        String ip = "10.23.4.213";
        int port = 1502;
        int slaveId = 1;
        ModbusAccessor modbus = ModbusAccessor.getInstance(ip, port, slaveId);

        // Test lettura/scrittura boolean
        modbus.writeBoolean(609, true);
        boolean boolValue = modbus.readBoolean(609);
        System.out.println("Boolean value: " + boolValue);

        // Test lettura/scrittura float
        modbus.writeFloat(89, 500);
        float floatValue = modbus.readFloat(200);
        System.out.println("Float value: " + floatValue);

        modbus.disconnect();

    }
}

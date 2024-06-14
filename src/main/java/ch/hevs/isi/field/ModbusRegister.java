package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;

import java.util.HashMap;
import java.util.Map;

public abstract class ModbusRegister {

    private int address;

    public static Map<DataPoint, ModbusRegister> registerMap = new HashMap<DataPoint, ModbusRegister>();

    public ModbusRegister(int address) {
        this.address = address;

    }

    public static ModbusRegister getRegisterFromDataPoint(DataPoint dp) {
        return registerMap.get(dp);
    }

    public int getAddress() {
        return address;
    }

    public static void poll() {
        for (ModbusRegister register : registerMap.values()) {
            register.read();
        }
    }
    public static void printRegisterMap() {
        for (Map.Entry<DataPoint, ModbusRegister> entry : registerMap.entrySet()) {
            System.out.println("DataPoint: " + entry.getKey() + ", Register Address: " + entry.getValue().getAddress());
        }}

    public abstract void read();

    public abstract void write();

}

package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;

import java.util.HashMap;
import java.util.Map;

public abstract class ModbusRegister {

    private int address;

    protected static Map<DataPoint, ModbusRegister> registerMap = new HashMap<DataPoint, ModbusRegister>();

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
    public abstract void   read() ;

    public abstract void write() ;

}

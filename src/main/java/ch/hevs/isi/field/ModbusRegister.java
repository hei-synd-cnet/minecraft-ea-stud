package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class representing a Modbus register.
 */
public abstract class ModbusRegister {

    /** The address of the Modbus register. */
    private int address;

    /** A map storing the relationship between DataPoints and ModbusRegisters. */
    public static Map<DataPoint, ModbusRegister> registerMap = new HashMap<DataPoint, ModbusRegister>();

    /**
     * Constructs a ModbusRegister with the specified address.
     *
     * @param address the address of the Modbus register
     */
    public ModbusRegister(int address) {
        this.address = address;
    }

    /**
     * Retrieves the ModbusRegister associated with the specified DataPoint.
     *
     * @param dp the DataPoint
     * @return the ModbusRegister associated with the given DataPoint
     */
    public static ModbusRegister getRegisterFromDataPoint(DataPoint dp) {
        return registerMap.get(dp);
    }

    /**
     * Gets the address of the Modbus register.
     *
     * @return the address of the Modbus register
     */
    public int getAddress() {
        return address;
    }

    /**
     * Polls all registers and performs a read operation on each.
     */
    public static void poll() {
        for (ModbusRegister register : registerMap.values()) {
            register.read();
        }
    }

    /**
     * Prints the register map, showing the relationship between DataPoints and their corresponding register addresses.
     */
    public static void printRegisterMap() {
        for (Map.Entry<DataPoint, ModbusRegister> entry : registerMap.entrySet()) {
            System.out.println("DataPoint: " + entry.getKey() + ", Register Address: " + entry.getValue().getAddress());
        }
    }

    /**
     * Abstract method to read the value from the Modbus register.
     */
    public abstract void read();

    /**
     * Abstract method to write the value to the Modbus register.
     */
    public abstract void write();
}

package ch.hevs.isi.field;

import ch.hevs.isi.core.BooleanDataPoint;
/**
 * This class represents a Modbus register for boolean values.
 * It extends the {@link ModbusRegister} class and handles reading and writing boolean values.
 */
public class BooleanRegister extends ModbusRegister {

    private BooleanDataPoint bdp;


    /**
     * Constructs a BooleanRegister with the specified label, output/input status, and address.
     */
    public BooleanRegister( String label, boolean isOutput, int address) {
        super(address);
        this.bdp = new BooleanDataPoint(label, isOutput) ;
        registerMap.put(bdp,this);
    }

    /**
     * Reads the boolean value from the Modbus register and updates the {@link BooleanDataPoint}.
     */
    @Override
    public void read() {

        boolean value = ModbusAccessor.getInstance().readBoolean(getAddress());
        bdp.setValue(value);
    }
    /**
     * Writes the boolean value from the {@link BooleanDataPoint} to the Modbus register.
     */
    @Override
    public void write() {
        ModbusAccessor.getInstance().writeBoolean(getAddress(), bdp.getValue());
    }
}
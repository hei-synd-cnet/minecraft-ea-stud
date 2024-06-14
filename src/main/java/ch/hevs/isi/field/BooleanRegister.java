package ch.hevs.isi.field;

import ch.hevs.isi.core.BooleanDataPoint;

public class BooleanRegister extends ModbusRegister {

    private boolean value;
    private BooleanDataPoint bdp;


    public BooleanRegister( BooleanDataPoint bdp, int address, boolean value) {
        super(address);
        this.bdp = bdp;
        this.value = value;
    }


    @Override
    public void read() {

        value = ModbusAccessor.getInstance().readBoolean(getAddress());
        bdp.setValue(value);
    }

    @Override
    public void write() {
        ModbusAccessor.getInstance().writeBoolean(getAddress(), bdp.getValue());
    }
}
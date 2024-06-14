package ch.hevs.isi.field;

import ch.hevs.isi.core.BooleanDataPoint;

public class BooleanRegister extends ModbusRegister {

    private BooleanDataPoint bdp;


    public BooleanRegister( String label, boolean isOutput, int address) {
        super(address);
        this.bdp = new BooleanDataPoint(label, isOutput) ;
        registerMap.put(bdp,this);
    }


    @Override
    public void read() {

        boolean value = ModbusAccessor.getInstance().readBoolean(getAddress());
        bdp.setValue(value);
    }

    @Override
    public void write() {
        ModbusAccessor.getInstance().writeBoolean(getAddress(), bdp.getValue());
    }
}
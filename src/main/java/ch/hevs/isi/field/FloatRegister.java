package ch.hevs.isi.field;

import ch.hevs.isi.core.FloatDataPoint;

public class FloatRegister extends ModbusRegister {

    private float value;
    private FloatDataPoint fdp;
    private int range;
    private int offset;

    public FloatRegister(FloatDataPoint fdp, float value, int address, int range, int offset) {
        super(address);
        this.fdp = fdp;
        this.value = value;
        this.range = range;
        this.offset = offset;
    }

    @Override
    public void read() {
        float newValue = ModbusAccessor.getInstance().readFloat(getAddress()) * range + offset;
        fdp.setValue(newValue);

    }

    @Override
    public void write() {
        ModbusAccessor.getInstance().writeFloat(getAddress(), fdp.getValue());
    }
}


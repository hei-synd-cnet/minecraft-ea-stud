package ch.hevs.isi.field;

import ch.hevs.isi.core.FloatDataPoint;

import java.util.Objects;

public class FloatRegister extends ModbusRegister {

    private FloatDataPoint fdp;
    private int range;
    private int offset;

    public FloatRegister(String label, boolean isOutput, int address, int range, int offset) {
        super(address);
        this.fdp = new FloatDataPoint(label,isOutput);
        this.range = range;
        this.offset = offset;
        registerMap.put(fdp,this);
    }

    @Override
    public void read() {
        float newValue = Objects.requireNonNull(ModbusAccessor.getInstance()).readFloat(getAddress()) * range + offset;
        fdp.setValue(newValue);

    }

    @Override
    public void write() {
        if (fdp.isOutput()){
            Objects.requireNonNull(ModbusAccessor.getInstance()).writeFloat(getAddress(), (fdp.getValue() - offset)/range); //Avoir valeur entre 0 et 1
        };
    }
}


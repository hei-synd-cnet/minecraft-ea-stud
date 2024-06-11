package ch.hevs.isi.field;
import ch.hevs.isi.core.BooleanDataPoint;
import ch.hevs.isi.core.FloatDataPoint;

public class FloatRegister extends ModbusRegister {
    private FloatDataPoint fdp;
    private Float value;
    public FloatRegister(int adress, String label, boolean isOutput) {
        super(adress); // Call the constructor of the superclass
        fdp = new FloatDataPoint(label, isOutput);
        modbusRegisterMap.put(fdp, this);
    }

    @Override
    public void read() {
        value = (Float) ModbusAccessor.readFloat(adress);
        fdp.setValue(value);
    }

    @Override
    public void write() {
        value = fdp.getValue();
        ModbusAccessor.writeFloat(adress, value);
    }
}

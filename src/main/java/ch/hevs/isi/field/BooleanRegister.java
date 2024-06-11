package ch.hevs.isi.field;
import ch.hevs.isi.core.BooleanDataPoint;

public class BooleanRegister extends ModbusRegister {
    private BooleanDataPoint bdp;
    private Boolean value;

    public BooleanRegister(int adress, String label, boolean isOutput) {
        super(adress); // Call the constructor of the superclass
        bdp = new BooleanDataPoint(label, isOutput);
        modbusRegisterMap.put(bdp, this);

    }

    @Override
    public void read() {
        value = ModbusAccessor.readBoolean(adress);
        bdp.setValue(value);
    }

    @Override
    public void write() {
        value = bdp.getValue();
        ModbusAccessor.writeBoolean(adress, value);
    }
}

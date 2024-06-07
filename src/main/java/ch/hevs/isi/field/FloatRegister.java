package ch.hevs.isi.field;

import ch.hevs.isi.core.FloatDataPoint;

public class FloatRegister extends ModbusRegister {

    private float value;
    private FloatDataPoint fdp;
    private int range;
    private int offset;

    public FloatRegister(FloatDataPoint fdp, float value, int adress) {
        super(adress);
        this.fdp = fdp;
        this.value = value;


    }

    public void read(int addr) {
        ModbusAccessor modbus = ModbusAccessor.getInstance("10.23.4.213", 1502, 1);
        value = modbus.readFloat(addr)*range + offset;
        fdp.setValue(value);
        modbus.disconnect();
    }

    public void write(int addr) {
        ModbusAccessor modbus = ModbusAccessor.getInstance("10.23.4.213", 1502, 1);
        modbus.writeFloat(addr, fdp.getValue());
        modbus.disconnect();
    }

    @Override
    public void read() {
        ModbusAccessor modbus = ModbusAccessor.getInstance("10.23.4.213", 1502, 1);
        ModbusRegister addr = null;
        modbus.writeFloat(addr.getAddress(), fdp.getValue());
        modbus.disconnect();

    }

    @Override
    public void write() {
        ModbusAccessor modbus = ModbusAccessor.getInstance("10.23.4.213", 1502, 1);
        ModbusRegister addr = null;
        modbus.writeFloat(addr.getAddress(), fdp.getValue());
        modbus.disconnect();
    }
}

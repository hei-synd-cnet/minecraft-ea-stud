package ch.hevs.isi.field;

import ch.hevs.isi.core.BooleanDataPoint;

public class BooleanRegister extends ModbusRegister {

    private boolean value;
    private BooleanDataPoint bdp;


    public BooleanRegister(BooleanDataPoint bdp, boolean value, int address) {
        super(address);
        this.bdp = bdp;
        this.value = value;
    }

    public void read(int addr) {
        ModbusAccessor modbus = ModbusAccessor.getInstance("10.23.4.213", 1502, 1);
        value = modbus.readBoolean(addr);
        bdp.setValue(value);
        modbus.disconnect();

    }

    @Override
    public void read() {
        ModbusAccessor modbus = ModbusAccessor.getInstance("10.23.4.213", 1502, 1);
        ModbusRegister addr = null;
        modbus.writeBoolean(addr.getAddress(), bdp.getValue());
        modbus.disconnect();
    }

    @Override
    public void write() {
        ModbusAccessor modbus = ModbusAccessor.getInstance("10.23.4.213", 1502, 1);
        ModbusRegister addr = null;
        value = modbus.readBoolean(addr.getAddress());
        bdp.setValue(value);
        modbus.disconnect();

    }
}
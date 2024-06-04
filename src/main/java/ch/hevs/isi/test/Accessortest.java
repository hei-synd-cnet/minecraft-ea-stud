package ch.hevs.isi.test;

import ch.hevs.isi.core.BooleanDataPoint;
import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.FloatDataPoint;
import ch.hevs.isi.field.ModbusAccessor;
import ch.hevs.isi.field.ModbusAccessor;
import com.serotonin.modbus4j.ModbusMaster;

public class Accessortest {
    public static void main(String[] args){

        ModbusAccessor.create();
        ModbusAccessor.connect("localhost",1502);
        System.out.println(ModbusAccessor.readBoolean(609));
        System.out.println(ModbusAccessor.readFloat(61));
        ModbusAccessor.writeBoolean(401,true);
        ModbusAccessor.writeFloat(209,0.3f);
        System.out.println(ModbusAccessor.readBoolean(609));
        System.out.println(ModbusAccessor.readFloat(209));
    }
}

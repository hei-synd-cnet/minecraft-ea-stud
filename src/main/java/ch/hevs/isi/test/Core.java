package ch.hevs.isi.test;

import ch.hevs.isi.core.BooleanDataPoint;
import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.FloatDataPoint;
import ch.hevs.isi.field.ModbusAccessor;
import ch.hevs.isi.field.ModbusRegister;
import ch.hevs.isi.field.PollTask;

import java.util.Timer;

import static ch.hevs.isi.core.DataPoint.getDataPointFromLabel;

public class Core {
    public static void main(String[] args) {
        String ip = "10.93.2.121";
        int port = 1502;
        int slaveId = 1;
        ModbusAccessor modbus = ModbusAccessor.getInstance(ip, port, slaveId);

        /**Create some dataPoint object*/

        new BooleanDataPoint("b1", true);
        new FloatDataPoint("f1", 66.66f);

        BooleanDataPoint bdp = (BooleanDataPoint) getDataPointFromLabel("b1");
        FloatDataPoint fdp = (FloatDataPoint) getDataPointFromLabel("f1");

        System.out.println(bdp);
        System.out.println(fdp + "\n");

        bdp.setValue(false);
        System.out.println("\n");
        fdp.setValue(47.4747f);
        System.out.println("\n");
        System.out.println(bdp);
        System.out.println(fdp);
        modbus.disconnect();




    }
}

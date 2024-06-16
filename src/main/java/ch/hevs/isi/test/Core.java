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
        String ip = "10.93.4.250";
        int port = 1502;
        int slaveId = 1;
        ModbusAccessor modbus = ModbusAccessor.getInstance(ip, port, slaveId);

        /**Pooling management*/
        Timer pollTimer = new Timer();
        pollTimer.scheduleAtFixedRate(new PollTask(), 5000, 2000);

//        modbus.disconnect();

    }
}

package ch.hevs.isi.test;

import ch.hevs.isi.core.BooleanDataPoint;
import ch.hevs.isi.core.FloatDataPoint;
import ch.hevs.isi.field.*;

import java.util.Timer;

public class ModBus {
    public static void main(String[] args) {
        String ip = "10.93.4.250";
        int port = 1502;
        int slaveId = 1;
        ModbusAccessor modbus = ModbusAccessor.getInstance(ip, port, slaveId);
        Timer pollTimer = new Timer();
        pollTimer.scheduleAtFixedRate(new PollTask(), 5000, 2000);
    }
}

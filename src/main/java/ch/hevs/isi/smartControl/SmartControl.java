package ch.hevs.isi.smartControl;

import ch.hevs.isi.core.BooleanDataPoint;
import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.FloatDataPoint;
import ch.hevs.isi.field.FloatRegister;
import ch.hevs.isi.field.ModbusAccessor;
import ch.hevs.isi.field.PollTask;
import ch.hevs.isi.core.CSVParser;
import java.util.Timer;
import java.util.TimerTask;

import ch.hevs.isi.field.ModbusRegister;
import ch.hevs.isi.utils.Utility;

public class SmartControl extends TimerTask {

    public static void main(String[] args) {

        /** Connexion*/
        String ip = "10.93.4.250";
        int port = 1502;
        int slaveId = 1;
        ModbusAccessor.getInstance(ip, port, slaveId);


        CSVParser.creatDatapoint();


        /**Pooling management*/
        Timer pollTimer = new Timer();
        pollTimer.scheduleAtFixedRate(new PollTask(), 5000, 2000);

        /** Control : From ModbusMap, the only values that are outputs are Remote_... (only 4 values); the others are inputs*/

        while (true) {
            ModbusRegister.getRegisterFromDataPoint(DataPoint.getDataPointFromLabel("SOLAR_P_FLOAT")).read();
            DataPoint solarValue = DataPoint.getDataPointFromLabel("SOLAR_P_FLOAT");
            System.out.println(solarValue);
            Utility.waitSomeTime(2000);
        }






//        modbus.disconnect();
    }

    @Override
    public void run() {
        System.out.println("Smart Control running");
        FloatDataPoint battery = (FloatDataPoint) DataPoint.getDataPointFromLabel("BATT_CHRG_FLOAT");
        BooleanDataPoint solar = (BooleanDataPoint) DataPoint.getDataPointFromLabel("REMOTE_SOLAR_SW");
        FloatDataPoint factory = (FloatDataPoint) DataPoint.getDataPointFromLabel("REMOTE_FACTORY_SP");

        if (battery.getValue() < 0.25f) {
            solar.setValue(true);
            factory.setValue(0.0f);
        } else if (battery.getValue() > 0.8f) {
            solar.setValue(false);
            factory.setValue(1.0f);
        }

    }
}






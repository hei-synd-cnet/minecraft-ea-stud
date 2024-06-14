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

    /** Code for Control Minecraft*/
    @Override
    public void run() {
        System.out.println("Smart Control running");

        /**Time Control*/
        FloatDataPoint clockTime  = (FloatDataPoint) DataPoint.getDataPointFromLabel("CLOCK_FLOAT");
        float day = 0f;
        if (clockTime.getValue() == 1.0f){
            day ++;
        }



        /**Producer Action*/
        FloatDataPoint factorySetPoint = (FloatDataPoint) DataPoint.getDataPointFromLabel("REMOTE_FACTORY_SP");
        FloatDataPoint coalSetPoint = (FloatDataPoint) DataPoint.getDataPointFromLabel("REMOTE_COAL_SP");
        BooleanDataPoint solarSwitch = (BooleanDataPoint) DataPoint.getDataPointFromLabel("REMOTE_SOLAR_SW");
        BooleanDataPoint windSwitch = (BooleanDataPoint) DataPoint.getDataPointFromLabel("REMOTE_WIND_SW");


        /**Consummer Information*/
        FloatDataPoint homeConsumation = (FloatDataPoint) DataPoint.getDataPointFromLabel("HOME_P_FLOAT");
        FloatDataPoint publicConsumation  = (FloatDataPoint) DataPoint.getDataPointFromLabel("PUBLIC_P_FLOAT");


        /**General Information */
        FloatDataPoint battery = (FloatDataPoint) DataPoint.getDataPointFromLabel("BATT_CHRG_FLOAT");
        FloatDataPoint grid = (FloatDataPoint) DataPoint.getDataPointFromLabel("GRID_U_FLOAT");
        FloatDataPoint batterPower = (FloatDataPoint) DataPoint.getDataPointFromLabel("BATT_P_FLOAT");
        FloatDataPoint solarPower = (FloatDataPoint) DataPoint.getDataPointFromLabel("SOLAR_P_FLOAT");
        FloatDataPoint windPower = (FloatDataPoint) DataPoint.getDataPointFromLabel("WIND_P_FLOAT");
        FloatDataPoint coalPower = (FloatDataPoint) DataPoint.getDataPointFromLabel("COAL_P_FLOAT");
        FloatDataPoint coalAmount = (FloatDataPoint) DataPoint.getDataPointFromLabel("COAL_AMOUNT");
        FloatDataPoint factoryPower = (FloatDataPoint) DataPoint.getDataPointFromLabel("FACTORY_P_FLOAT");
        FloatDataPoint bunkerPower = (FloatDataPoint) DataPoint.getDataPointFromLabel("BUNKER_P_FLOAT");
        FloatDataPoint windValue = (FloatDataPoint) DataPoint.getDataPointFromLabel("WIND_FLOAT");
        FloatDataPoint weatherValue = (FloatDataPoint) DataPoint.getDataPointFromLabel("WEATHER_FLOAT");
        FloatDataPoint weatherForecast = (FloatDataPoint) DataPoint.getDataPointFromLabel("WEATHER_FORECAST_FLOAT");
        FloatDataPoint weatherCountdown = (FloatDataPoint) DataPoint.getDataPointFromLabel("WEATHER_COUNTDOWN_FLOAT");

        FloatDataPoint factoryEnergy = (FloatDataPoint) DataPoint.getDataPointFromLabel("FACTORY_ENERGY");
        FloatDataPoint score = (FloatDataPoint) DataPoint.getDataPointFromLabel("SCORE");
        FloatDataPoint factoryState = (FloatDataPoint) DataPoint.getDataPointFromLabel("FACTORY_ST");
        FloatDataPoint coalState = (FloatDataPoint) DataPoint.getDataPointFromLabel("COAL_ST");




        /**Battery Management*/


    }
}






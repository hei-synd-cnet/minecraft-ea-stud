package ch.hevs.isi.test;

import ch.hevs.isi.core.BooleanDataPoint;
import ch.hevs.isi.core.FloatDataPoint;
import ch.hevs.isi.field.*;

import java.util.Timer;

public class ModBus {
    public static void main(String[] args) {
        String ip = "10.93.2.230";
        int port = 1502;
        int slaveId = 1;
        ModbusAccessor modbus = ModbusAccessor.getInstance(ip, port, slaveId);

//        // Test lettura/scrittura boolean
//        boolean boolValue = modbus.readBoolean(613);
//        System.out.println("Boolean value: " + boolValue);
//        modbus.writeBoolean(613, true);
//        boolValue = modbus.readBoolean(613);
//        System.out.println("Boolean value: " + boolValue);
//
//        // Test lettura/scrittura float
//        modbus.writeFloat(89, 500);
//        float floatValue = modbus.readFloat(200);
//        System.out.println("Float value: " + floatValue);

        //modbus.disconnect();
        FloatDataPoint GRID_U_FLOAT = new FloatDataPoint("GRID_U_FLOAT", 0.0f);
        FloatRegister GRID_U_FLOAT_r = new FloatRegister(GRID_U_FLOAT, 0.0f, 89, 1000, 0);
        ModbusRegister.registerMap.put(GRID_U_FLOAT, GRID_U_FLOAT_r);

        FloatDataPoint BATT_P_FLOAT = new FloatDataPoint("BATT_P_FLOAT", 0.0f);
        FloatRegister BATT_P_FLOAT_r = new FloatRegister(BATT_P_FLOAT, 0.0f, 57, 6000, -3000);
        ModbusRegister.registerMap.put(BATT_P_FLOAT, BATT_P_FLOAT_r);

        FloatDataPoint BATT_CHRG_FLOAT = new FloatDataPoint("BATT_CHRG_FLOAT", 0.0f);
        FloatRegister BATT_CHRG_FLOAT_r = new FloatRegister(BATT_CHRG_FLOAT, 0.0f, 61, 1500, 0);
        ModbusRegister.registerMap.put(BATT_CHRG_FLOAT, BATT_CHRG_FLOAT_r);

        FloatDataPoint SOLAR_P_FLOAT = new FloatDataPoint("SOLAR_P_FLOAT", 0.0f);
        FloatRegister SOLAR_P_FLOAT_r = new FloatRegister(SOLAR_P_FLOAT, 0.0f, 53, 1000, 0);
        ModbusRegister.registerMap.put(SOLAR_P_FLOAT, SOLAR_P_FLOAT_r);

        FloatDataPoint WIND_P_FLOAT = new FloatDataPoint("WIND_P_FLOAT", 0.0f);
        FloatRegister WIND_P_FLOAT_r = new FloatRegister(WIND_P_FLOAT, 0.0f, 81, 600, 0);
        ModbusRegister.registerMap.put(WIND_P_FLOAT, WIND_P_FLOAT_r);

        FloatDataPoint COAL_P_FLOAT = new FloatDataPoint("COAL_P_FLOAT", 0.0f);
        FloatRegister COAL_P_FLOAT_r = new FloatRegister(COAL_P_FLOAT, 0.0f, 57, 1000, 0);
        ModbusRegister.registerMap.put(COAL_P_FLOAT, COAL_P_FLOAT_r);

        FloatDataPoint COAL_AMOUNT = new FloatDataPoint("COAL_AMOUNT", 0.0f);
        FloatRegister COAL_AMOUNT_r = new FloatRegister(COAL_AMOUNT, 0.0f, 65, 1, 0);
        ModbusRegister.registerMap.put(COAL_AMOUNT, COAL_AMOUNT_r);

        FloatDataPoint HOME_P_FLOAT = new FloatDataPoint("HOME_P_FLOAT", 0.0f);
        FloatRegister HOME_P_FLOAT_r = new FloatRegister(HOME_P_FLOAT, 0.0f, 101, 1000, 0);
        ModbusRegister.registerMap.put(HOME_P_FLOAT, HOME_P_FLOAT_r);

        FloatDataPoint PUBLIC_P_FLOAT = new FloatDataPoint("PUBLIC_P_FLOAT", 0.0f);
        FloatRegister PUBLIC_P_FLOAT_r = new FloatRegister(PUBLIC_P_FLOAT, 0.0f, 97, 500, 0);
        ModbusRegister.registerMap.put(PUBLIC_P_FLOAT, PUBLIC_P_FLOAT_r);

        FloatDataPoint FACTORY_P_FLOAT = new FloatDataPoint("FACTORY_P_FLOAT", 0.0f);
        FloatRegister FACTORY_P_FLOAT_r = new FloatRegister(FACTORY_P_FLOAT, 0.0f, 105, 2000, 0);
        ModbusRegister.registerMap.put(FACTORY_P_FLOAT, FACTORY_P_FLOAT_r);

        FloatDataPoint BUNKER_P_FLOAT = new FloatDataPoint("BUNKER_P_FLOAT", 0.0f);
        FloatRegister BUNKER_P_FLOAT_r = new FloatRegister(BUNKER_P_FLOAT, 0.0f, 93, 500, 0);
        ModbusRegister.registerMap.put(BUNKER_P_FLOAT, BUNKER_P_FLOAT_r);

        FloatDataPoint WIND_FLOAT = new FloatDataPoint("WIND_FLOAT", 0.0f);
        FloatRegister WIND_FLOAT_r = new FloatRegister(WIND_FLOAT, 0.0f, 301, 1, 0);
        ModbusRegister.registerMap.put(WIND_FLOAT, WIND_FLOAT_r);

        FloatDataPoint WEATHER_FLOAT = new FloatDataPoint("WEATHER_FLOAT", 0.0f);
        FloatRegister WEATHER_FLOAT_r = new FloatRegister(WEATHER_FLOAT, 0.0f, 305, 1, 0);
        ModbusRegister.registerMap.put(WEATHER_FLOAT, WEATHER_FLOAT_r);

        FloatDataPoint WEATHER_FORECAST_FLOAT = new FloatDataPoint("WEATHER_FORECAST_FLOAT", 0.0f);
        FloatRegister WEATHER_FORECAST_FLOAT_r = new FloatRegister(WEATHER_FORECAST_FLOAT, 0.0f, 309, 1, 0);
        ModbusRegister.registerMap.put(WEATHER_FORECAST_FLOAT, WEATHER_FORECAST_FLOAT_r);

        FloatDataPoint WEATHER_COUNTDOWN_FLOAT = new FloatDataPoint("WEATHER_COUNTDOWN_FLOAT", 0.0f);
        FloatRegister WEATHER_COUNTDOWN_FLOAT_r = new FloatRegister(WEATHER_COUNTDOWN_FLOAT, 0.0f, 313, 600, 0);
        ModbusRegister.registerMap.put(WEATHER_COUNTDOWN_FLOAT, WEATHER_COUNTDOWN_FLOAT_r);

        FloatDataPoint CLOCK_FLOAT = new FloatDataPoint("CLOCK_FLOAT", 0.0f);
        FloatRegister CLOCK_FLOAT_r = new FloatRegister(CLOCK_FLOAT, 0.0f, 317, 1, 0);
        ModbusRegister.registerMap.put(CLOCK_FLOAT, CLOCK_FLOAT_r);

        FloatDataPoint REMOTE_COAL_SP = new FloatDataPoint("REMOTE_COAL_SP", 0.0f);
        FloatRegister REMOTE_COAL_SP_r = new FloatRegister(REMOTE_COAL_SP, 0.0f, 209, 1, 0);
        ModbusRegister.registerMap.put(REMOTE_COAL_SP, REMOTE_COAL_SP_r);

        FloatDataPoint REMOTE_FACTORY_SP = new FloatDataPoint("REMOTE_FACTORY_SP", 0.0f);
        FloatRegister REMOTE_FACTORY_SP_r = new FloatRegister(REMOTE_FACTORY_SP, 0.0f, 205, 1, 0);
        ModbusRegister.registerMap.put(REMOTE_FACTORY_SP, REMOTE_FACTORY_SP_r);

        BooleanDataPoint REMOTE_SOLAR_SW = new BooleanDataPoint("REMOTE_SOLAR_SW", true);
        BooleanRegister REMOTE_SOLAR_SW_r = new BooleanRegister(REMOTE_SOLAR_SW,401, true);
        ModbusRegister.registerMap.put(REMOTE_SOLAR_SW, REMOTE_SOLAR_SW_r);

        BooleanDataPoint REMOTE_WIND_SW = new BooleanDataPoint("REMOTE_WIND_SW", true);
        BooleanRegister REMOTE_WIND_SW_r = new BooleanRegister(REMOTE_SOLAR_SW,405, true);
        ModbusRegister.registerMap.put(REMOTE_WIND_SW, REMOTE_WIND_SW_r);

        FloatDataPoint FACTORY_ENERGY = new FloatDataPoint("FACTORY_ENERGY", 0.0f);
        FloatRegister FACTORY_ENERGY_r = new FloatRegister(FACTORY_ENERGY, 0.0f, 341, 3600000, 0);
        ModbusRegister.registerMap.put(FACTORY_ENERGY, FACTORY_ENERGY_r);

        FloatDataPoint SCORE = new FloatDataPoint("SCORE", 0.0f);
        FloatRegister SCORE_r = new FloatRegister(SCORE, 0.0f, 345, 3600000, 0);
        ModbusRegister.registerMap.put(SCORE, SCORE_r);

        FloatDataPoint COAL_ST = new FloatDataPoint("COAL_ST", 0.0f);
        FloatRegister COAL_ST_r = new FloatRegister(COAL_ST, 0.0f, 601, 1, 0);
        ModbusRegister.registerMap.put(COAL_ST, COAL_ST_r);

        FloatDataPoint FACTORY_ST = new FloatDataPoint("REMOTE_FACTORY_SP", 0.0f);
        FloatRegister FACTORY_ST_r = new FloatRegister(FACTORY_ST, 0.0f, 605, 1, 0);
        ModbusRegister.registerMap.put(FACTORY_ST, FACTORY_ST_r);

        BooleanDataPoint SOLAR_CONNECT_ST = new BooleanDataPoint("SOLAR_CONNECT_ST", true);
        BooleanRegister SOLAR_CONNECT_ST_r = new BooleanRegister(REMOTE_SOLAR_SW,609, true);
        ModbusRegister.registerMap.put(SOLAR_CONNECT_ST, SOLAR_CONNECT_ST_r);

        BooleanDataPoint WIND_CONNECT_ST = new BooleanDataPoint("WIND_CONNECT_ST", true);
        BooleanRegister WIND_CONNECT_ST_r = new BooleanRegister(WIND_CONNECT_ST,613, true);
        ModbusRegister.registerMap.put(WIND_CONNECT_ST, WIND_CONNECT_ST_r);

        BooleanDataPoint SIM_ENABLE = new BooleanDataPoint("SIM_ENABLE", false);
        BooleanRegister SIM_ENABLE_r = new BooleanRegister(SIM_ENABLE,409, true);
        ModbusRegister.registerMap.put(SIM_ENABLE, SIM_ENABLE_r);

        SIM_ENABLE_r.write();
        SIM_ENABLE_r.read();
        System.out.println(SIM_ENABLE);


        // Stampa del contenuto della mappa
       // ModbusRegister.printRegisterMap();
        Timer pollTimer = new Timer();
        pollTimer.scheduleAtFixedRate(new PollTask(), 5000, 2000);
    }

}

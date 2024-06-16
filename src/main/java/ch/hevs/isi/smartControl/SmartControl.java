package ch.hevs.isi.smartControl;

import ch.hevs.isi.core.BooleanDataPoint;
import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.FloatDataPoint;
import ch.hevs.isi.field.ModbusAccessor;
import ch.hevs.isi.field.PollTask;
import ch.hevs.isi.core.CSVParser;
import java.util.Timer;
import java.util.TimerTask;

/**
 * SmartControl is a program that manages control and monitoring of various data points
 * related to a smart energy system using Modbus communication protocol.
 * It periodically polls data points and adjusts control parameters based on various conditions
 * such as power consumption, generation from renewable sources, battery level, and weather forecast.
 */
public class SmartControl extends TimerTask {

    /**
     * Entry point for the SmartControl program.
     * Initializes Modbus connection and data points, starts polling at fixed intervals.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        // Modbus connection parameters
        String ip = "192.168.1.24";
        int port = 1502;
        int slaveId = 1;

        // Initialize ModbusAccessor with specified parameters
        ModbusAccessor.getInstance(ip, port, slaveId);

        // Create data points from CSV file
        CSVParser.creatDatapoint();

        // Timer for polling task
        Timer pollTimer = new Timer();
        // Schedule polling task to run every 2 seconds with initial delay of 5 seconds
        pollTimer.scheduleAtFixedRate(new PollTask(), 5000, 2000);
    }

    /**
     * Runs the SmartControl logic periodically.
     * This method is called by the TimerTask scheduler at fixed intervals.
     */
    @Override
    public void run() {
        System.out.println("Smart Control running");

        // Retrieve data points for control and monitoring
        FloatDataPoint clockTime = (FloatDataPoint) DataPoint.getDataPointFromLabel("CLOCK_FLOAT");
        FloatDataPoint factorySetPoint = (FloatDataPoint) DataPoint.getDataPointFromLabel("REMOTE_FACTORY_SP");
        FloatDataPoint coalSetPoint = (FloatDataPoint) DataPoint.getDataPointFromLabel("REMOTE_COAL_SP");
        BooleanDataPoint solarSwitch = (BooleanDataPoint) DataPoint.getDataPointFromLabel("REMOTE_SOLAR_SW");
        BooleanDataPoint windSwitch = (BooleanDataPoint) DataPoint.getDataPointFromLabel("REMOTE_WIND_SW");
        FloatDataPoint homeConsumption = (FloatDataPoint) DataPoint.getDataPointFromLabel("HOME_P_FLOAT");
        FloatDataPoint publicConsumption = (FloatDataPoint) DataPoint.getDataPointFromLabel("PUBLIC_P_FLOAT");
        FloatDataPoint batteryLevel = (FloatDataPoint) DataPoint.getDataPointFromLabel("BATT_CHRG_FLOAT");
        FloatDataPoint grid = (FloatDataPoint) DataPoint.getDataPointFromLabel("GRID_U_FLOAT");
        FloatDataPoint solarPower = (FloatDataPoint) DataPoint.getDataPointFromLabel("SOLAR_P_FLOAT");
        FloatDataPoint windPower = (FloatDataPoint) DataPoint.getDataPointFromLabel("WIND_P_FLOAT");
        FloatDataPoint coalAmount = (FloatDataPoint) DataPoint.getDataPointFromLabel("COAL_AMOUNT");
        FloatDataPoint factoryPower = (FloatDataPoint) DataPoint.getDataPointFromLabel("FACTORY_P_FLOAT");
        FloatDataPoint bunkerPower = (FloatDataPoint) DataPoint.getDataPointFromLabel("BUNKER_P_FLOAT");
        FloatDataPoint currentWeather = (FloatDataPoint) DataPoint.getDataPointFromLabel("WEATHER_FORECAST_FLOAT");

        // Calculate total power consumption
        float totalConsumption = homeConsumption.getValue() + publicConsumption.getValue() + factoryPower.getValue() + bunkerPower.getValue();

        // Calculate total power generated from renewable sources
        float renewableGeneration = solarPower.getValue() + windPower.getValue();

        // Calculate power deficit relative to total consumption
        float powerDeficit = totalConsumption - renewableGeneration;

        // Adjust coal production based on power deficit
        if (powerDeficit > 0) {
            if (coalAmount.getValue() > 40f) {
                coalSetPoint.setValue(0.8f);
            } else if (coalAmount.getValue() <= 40 && coalAmount.getValue() > 15) {
                coalSetPoint.setValue(0.6f);
            } else if (coalAmount.getValue() <= 15) {
                coalSetPoint.setValue(0.1f);
            }

            // Check grid voltage
            float gridVoltage = grid.getValue();

            // Adjust production based on grid voltage
            if (gridVoltage > 910.0f) {
                factorySetPoint.setValue(1f); // Stop factory production
                coalSetPoint.setValue(0.0f); // Stop coal production
                solarSwitch.setValue(false); // Disable solar panels
                windSwitch.setValue(false); // Disable wind turbines
            } else if (gridVoltage < 800) {
                factorySetPoint.setValue(0f); // Maximize factory production
                coalSetPoint.setValue(1.0f); // Maximize coal production
                solarSwitch.setValue(true); // Enable solar panels
                windSwitch.setValue(true); // Enable wind turbines
            }
        }

        // Adjust battery charge/discharge based on battery level
        if (batteryLevel.getValue() < 0.6f) {
            // Battery almost empty, take measures to recharge it
            solarSwitch.setValue(true);
            windSwitch.setValue(true);
            factorySetPoint.setValue(0.0f);
            coalSetPoint.setValue(1.0f);
        } else if (batteryLevel.getValue() > 0.95f) {
            // Battery almost full, take measures to discharge it
            solarSwitch.setValue(false);
            windSwitch.setValue(false);
            factorySetPoint.setValue(1.0f);
            coalSetPoint.setValue(0.0f);
        }

        // Adjust renewable production based on weather conditions
        switch ((int) currentWeather.getValue()) {
            case 0: // Clear weather
                solarSwitch.setValue(true);
                windSwitch.setValue(true);
                break;
            case 1: // Rainy weather
                solarSwitch.setValue(false);
                windSwitch.setValue(true);
                break;
            case 2: // Thunderstorm
                solarSwitch.setValue(false);
                windSwitch.setValue(false);
                break;
        }

        // Adjust factory production based on battery level
        if (batteryLevel.getValue() > 0.7f && batteryLevel.getValue() <= 0.9f) {
            factorySetPoint.setValue(0.94f);
        } else if (batteryLevel.getValue() > 0.5f && batteryLevel.getValue() <= 0.7f) {
            factorySetPoint.setValue(0.4f);
        } else if (batteryLevel.getValue() > 0.3f && batteryLevel.getValue() <= 0.5f) {
            factorySetPoint.setValue(0.15f);
        } else if (batteryLevel.getValue() > 0.25f && batteryLevel.getValue() <= 0.3f) {
            factorySetPoint.setValue(0.05f);
        } else if (batteryLevel.getValue() <= 0.25f) {
            factorySetPoint.setValue(0.0f);
        }
    }
}






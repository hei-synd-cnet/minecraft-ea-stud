package ch.hevs.isi.field;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.DataPointListener;
import ch.hevs.isi.db.DatabaseConnector;
import ch.hevs.isi.web.WebConnector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ModbusRegister {
    // Map to store data points by label
    protected static Map<DataPoint, ModbusRegister> modbusRegisterMap = new HashMap();

    // Fields to store label and output status
    protected int  adress;
    protected DataPoint dp;

    // List to store registered DataPointListeners
    //private static final List<DataPointListener> dpListenerList = new ArrayList<>();

    protected ModbusRegister(int adress) {
        this.adress = adress;
       // modbusRegisterMap.put(adress,this);
    }
    public static ModbusRegister getRegisterFromDataPoint(DataPoint dp){
    return modbusRegisterMap.get(dp);
    }

    public static void poll(){
//        for (Map.Entry<DataPoint, ModbusRegister> entry : modbusRegisterMap.entrySet()) {
//            ModbusRegister modbusRegister = entry.getValue();
//            modbusRegister.read();
//        }

        for (ModbusRegister mr: modbusRegisterMap.values()) {
            mr.read();
        }
    }

    public int getAdress() {
        return adress;
    }

    public abstract void read();

    public abstract void write();



}

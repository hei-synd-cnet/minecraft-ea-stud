package ch.hevs.isi.test;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.field.*;
import ch.hevs.isi.utils.Utility;

import java.util.Timer;

public class ModbusReisterTest {
    public static void main(String[] args){

        FieldConnector.initialize("localhost",1502);
        // REMOTE_COAL_SP;F;Y;Y;209;1;0
        FloatRegister fr = new FloatRegister(209, "REMOTE_COAL_SP", true);

        // REMOTE_SOLAR_SW;B;Y;Y;401;1;0
        BooleanRegister br = new BooleanRegister(401, "REMOTE_SOLAR_SW", true);

        System.out.println(ModbusAccessor.readBoolean(br.getAdress()));
        ModbusAccessor.writeFloat(fr.getAdress(), 0.7f);
        System.out.println(ModbusAccessor.readFloat(fr.getAdress()));

        DataPoint dp = DataPoint.getDataPointFromLabel("REMOTE_SOLAR_SW");
        System.out.println(dp);
        ModbusRegister mr = ModbusRegister.getRegisterFromDataPoint(dp);
        System.out.println(mr);

        Timer tmr = new Timer();
        tmr.scheduleAtFixedRate(new PollTask(),0,1000);


        Utility.waitSomeTime(20000);
        tmr.cancel();
    }
}

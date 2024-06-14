package ch.hevs.isi.field;

import ch.hevs.isi.smartControl.SmartControl;

import java.util.TimerTask;

public class PollTask extends TimerTask {


    @Override
    public void run() {
        ModbusRegister.poll();
    }

}

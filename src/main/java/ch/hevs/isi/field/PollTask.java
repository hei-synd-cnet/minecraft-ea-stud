package ch.hevs.isi.field;

import java.util.TimerTask;

/**
 * Task used for polling Modbus registers at regular intervals.
 */
public class PollTask extends TimerTask {

    /**
     * Implements the task's run method to execute the polling of Modbus registers.
     */
    @Override
    public void run() {
        ModbusRegister.poll();
    }

}
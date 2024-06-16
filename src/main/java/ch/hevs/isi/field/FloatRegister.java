package ch.hevs.isi.field;

import ch.hevs.isi.core.FloatDataPoint;

import java.util.Objects;

/**
 * Represents a Modbus register that holds a float value.
 */
public class FloatRegister extends ModbusRegister {

    /** The FloatDataPoint associated with this register. */
    private FloatDataPoint fdp;

    /** The range for scaling the float value. */
    private int range;

    /** The offset for scaling the float value. */
    private int offset;

    /**
     * Constructs a FloatRegister with the specified parameters.
     *
     * @param label the label of the FloatDataPoint
     * @param isOutput indicates whether the FloatDataPoint is an output
     * @param address the address of the Modbus register
     * @param range the range for scaling the float value
     * @param offset the offset for scaling the float value
     */
    public FloatRegister(String label, boolean isOutput, int address, int range, int offset) {
        super(address);
        this.fdp = new FloatDataPoint(label, isOutput);
        this.range = range;
        this.offset = offset;
        registerMap.put(fdp, this);
    }

    /**
     * Reads the float value from the Modbus register, scales it, and sets it in the FloatDataPoint.
     */
    @Override
    public void read() {
        float newValue = Objects.requireNonNull(ModbusAccessor.getInstance()).readFloat(getAddress()) * range + offset;
        fdp.setValue(newValue);
    }

    /**
     * Writes the scaled float value from the FloatDataPoint to the Modbus register if it is an output.
     */
    @Override
    public void write() {
        if (fdp.isOutput()) {
            Objects.requireNonNull(ModbusAccessor.getInstance()).writeFloat(getAddress(), (fdp.getValue() - offset) / range);
        }
    }
}


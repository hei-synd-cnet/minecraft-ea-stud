package ch.hevs.isi.core;

/**
 * Interface representing a listener for DataPoint value changes.
 */
public interface DataPointListener {

    /**
     * Called when a new value is available for a DataPoint.
     *
     * @param dp the DataPoint that has a new value
     */
    void oneNewValue(DataPoint dp);
}

package ch.hevs.isi.core;

public interface DataPointListener {
    /**
     * @param dp Call the listener on new value
     */
    public void onNewValue (DataPoint dp);
}

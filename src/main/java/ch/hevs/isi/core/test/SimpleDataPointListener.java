package ch.hevs.isi.core.test;
import ch.hevs.isi.core.DataPointListener;
import ch.hevs.isi.core.DataPoint;
public class SimpleDataPointListener implements DataPointListener {
    public void onNewValue(DataPoint dp) {
        System.out.println("New value for DataPoint: " + dp);
    }

}

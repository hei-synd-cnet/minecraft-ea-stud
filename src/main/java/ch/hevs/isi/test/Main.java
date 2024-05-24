package ch.hevs.isi.test;

import ch.hevs.isi.core.BooleanDataPoint;
import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.FloatDataPoint;
import ch.hevs.isi.db.DatabaseConnector;
import ch.hevs.isi.field.FieldConnector;
import ch.hevs.isi.web.WebConnector;

import javax.xml.crypto.Data;

/**
 * The main created below is to test the creation of a datapoint.
 */
public class Main {
    public static void main(String[] args){
        //DatabaseConnector.getInstance().initialize("test_bDp");
        //FieldConnector.getInstance().initialize("www.test2.com");
        //WebConnector.getInstance().initialize("www.test3.com");

        new FloatDataPoint("test_fDp", false);
        new BooleanDataPoint("test_bDp", false);

        BooleanDataPoint bDp = (BooleanDataPoint) DataPoint.getDataPointFromLabel("test_bDp");
        if (bDp != null) {
            bDp.setValue(true);
            bDp.setValue(false);
        } else {
            System.err.println("bDp is null");
        }

        FloatDataPoint fDp = (FloatDataPoint) DataPoint.getDataPointFromLabel("test_fDp");
        if (fDp != null) {
            fDp.setValue(15f);
            fDp.setValue(12f);
        } else {
            System.err.println("fDp is null");
        }
    }

}
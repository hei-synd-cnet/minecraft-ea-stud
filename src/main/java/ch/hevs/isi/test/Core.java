package ch.hevs.isi.test;

import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.FloatDataPoint;
import ch.hevs.isi.core.BooleanDataPoint;
import ch.hevs.isi.db.DataBaseConnector;
import ch.hevs.isi.field.FieldConnector;
import ch.hevs.isi.web.WebConnector;

import javax.xml.crypto.Data;

public class Core {
    public static void main(String[] args){
        DataBaseConnector.getInstance().initialize("123.12.23.45",123);
        FieldConnector.getInstance().initialize("123.12.23.45",123);
        WebConnector.getInstance().initialize("123.12.23.45",123);
        new FloatDataPoint("f_test", false);
        new BooleanDataPoint("b_test", true);

        BooleanDataPoint bp = (BooleanDataPoint) DataPoint.getDataPointFromLabel("b_test");
        bp.setValue(true);
        bp.setValue(false);
        FloatDataPoint fdp = (FloatDataPoint) DataPoint.getDataPointFromLabel("f_test");
        fdp.setValue(2.3f);
        fdp.setValue(3.4f);




    }
}

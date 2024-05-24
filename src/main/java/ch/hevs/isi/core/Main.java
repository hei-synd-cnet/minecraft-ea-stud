package ch.hevs.isi.core;


import ch.hevs.isi.db.DatabaseConnector;
import ch.hevs.isi.field.FieldConnector;
import ch.hevs.isi.web.WebConnector;

import javax.xml.crypto.Data;

/**
 * The main created below is to test the creation of a datapoint.
 */
public class Main {
    public static void main(String[] args){
        DatabaseConnector.getInstance().initialize("www.test1.com");
        FieldConnector.getInstance().initialize("www.test2.com");
        WebConnector.getInstance().initialize("www.test3.com");

        FloatDataPoint d1 = new FloatDataPoint("toto", false);
        d1.setValue(14f);

        BooleanDataPoint d2 = new BooleanDataPoint("tata", false);
        d2.setValue(true);

        FloatDataPoint Test = (FloatDataPoint) DataPoint.getDataPointFromLabel("toto");
        System.out.println(Test.getValue());
        Test.setValue(23.48379f);
        System.out.println(DataPoint.getDataPointFromLabel("toto").toString());
    }

}
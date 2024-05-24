package ch.hevs.isi.core;

import ch.hevs.isi.db.DataBaseConnector;
import ch.hevs.isi.field.FieldConnector;
import ch.hevs.isi.web.WebConnector;

public class Test {

    public static void main(String[] args){
        DataBaseConnector.getInstance().initialize("123.12.23.45",123);
        FieldConnector.getInstance().initialize("123.12.23.45",123);
        WebConnector.getInstance().initialize("123.12.23.45",123);
        BooleanDataPoint bdp = new BooleanDataPoint("AaA", false);
        FloatDataPoint fdap = new FloatDataPoint("PowerSolar", false);
        fdap.setValue(2.3f);
        System.out.println(fdap.getValue());
        bdp.setValue(true);
        System.out.println("WWWE");
        bdp.setValue(true);
        System.out.println("Après");
        System.out.println(bdp);
        System.out.println(fdap.getValue());
        System.out.println(bdp.toString());
        bdp.setValue(false);
        FloatDataPoint Recherche = (FloatDataPoint) DataPoint.getDataPointFromLabel("PowerSolar");
        System.out.println(Recherche.getValue());
        Recherche.setValue(543.23f);
        System.out.println(Recherche.getValue());
        System.out.println(DataPoint.getDataPointFromLabel("PowerSolar").toString());
        System.out.println(((BooleanDataPoint) DataPoint.getDataPointFromLabel("AaA")).getValue());
    }
}

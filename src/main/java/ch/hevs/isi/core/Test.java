package ch.hevs.isi.core;

public class Test {

    public static void main(String[] args){
        BooleanDataPoint bdp = new BooleanDataPoint("AaA", false);
        FloatDataPoint fdap = new FloatDataPoint("PowerSolar", false);
        fdap.setValue(2.3f);
        System.out.println(fdap.getValue());
        bdp.setValue(true);
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

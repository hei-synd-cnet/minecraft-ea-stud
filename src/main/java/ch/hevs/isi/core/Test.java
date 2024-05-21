package ch.hevs.isi.core;

public class Test {

    public static void main(String[] args){
        BooleanDataPoint bdp = new BooleanDataPoint("AaA", false);
        bdp.setValue(true);
        FloatDataPoint fdap = new FloatDataPoint("Power", false);
        fdap.setValue(2.3f);
        System.out.println(fdap.getValue());
        System.out.println(bdp.toString());
        FloatDataPoint Recherche = (FloatDataPoint) DataPoint.getDataPointFromLabel("Power");
        System.out.println(Recherche.getValue());
        System.out.println(DataPoint.getDataPointFromLabel("Power").toString());
        System.out.println(((BooleanDataPoint) DataPoint.getDataPointFromLabel("AaA")).getValue());
    }
}

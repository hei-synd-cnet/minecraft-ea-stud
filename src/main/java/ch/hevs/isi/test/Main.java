package ch.hevs.isi.test;

import ch.hevs.isi.core.BooleanDataPoint;
import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.FloatDataPoint;

import static ch.hevs.isi.core.DataPoint.getDataPointFromLabel;

public class Main {
    public static void main(String[] args){

        // Create some dataPoint object

        BooleanDataPoint b1 = new BooleanDataPoint("TOTO",true);
        FloatDataPoint f1 = new FloatDataPoint("f1",66.66f);

        System.out.println(b1);
        System.out.println(f1);

        b1.setValue(false);
        System.out.println(b1);
        f1.setValue(7474.777f);
        System.out.println(f1);

        System.out.println(getDataPointFromLabel("TOTO"));
        System.out.println(b1.getLabel());
        System.out.println(b1.getValue());
        System.out.println(f1.getValue());

        f1.isOutput(true);
        System.out.println(f1);


    }
}

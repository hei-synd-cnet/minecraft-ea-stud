package ch.hevs.isi.core;


/**
 * The main created below is to test the creation of a datapoint.
 */
public class Main {
    public static void main(String[] args){
        BooleanDataPoint d1 = new BooleanDataPoint("toto", false);
        d1.setValue(true);
        System.out.println(d1.toString());
    }

}
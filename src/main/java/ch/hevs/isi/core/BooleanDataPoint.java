package ch.hevs.isi.core;

public class BooleanDataPoint extends DataPoint {
    private boolean value;

    public BooleanDataPoint(String label, boolean isOutput){
        super(label, isOutput);
    }

    public void setValue(boolean value){
        this.value = value;
    }

    public boolean getValue(){
        return value;
    }

    public String toString(){
        return "label = " + label +"\n"
                + "isOutput = " + isOutput +"\n"
                + "value = " + value;
    }

    public static void main(String[] args) {

        BooleanDataPoint d1 = new BooleanDataPoint("toto", false);
        d1.setValue(true);
        System.out.println(d1.toString());
    }
}

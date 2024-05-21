package ch.hevs.isi.core;

public class BooleanDataPoint extends DataPoint {

    //Attribut
    protected boolean value;

    //Constructeur
    public BooleanDataPoint(String label, boolean value) {
        super(label);
        this.value = value;
    }

    //Méthodes
    public void setValue(boolean value) {
        this.value = value;
        // Notify all connectors
        update(true);
    }
    public boolean getValue() {
        return value;
    }
    public String toString() {
        return label + ", value: " + value;
    }
}

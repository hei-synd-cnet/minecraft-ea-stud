package ch.hevs.isi.core;

public class FloatDataPoint extends DataPoint{

    //Attribut
    protected float value;

    //Constructeur
    public FloatDataPoint(String label, float value) {
        super(label);
        this.value = value;
    }

    //Méthodes
    public void setValue(float value) {
        this.value = value;
        // Notify all connectors
        update(true);
    }
    public float getValue() {
        return value;
    }
    public String toString() {
        return label + ", value: " + value;
    }

}

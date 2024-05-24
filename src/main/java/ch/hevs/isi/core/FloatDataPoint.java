package ch.hevs.isi.core;

/**
 * The public class FlaotDataPoint extends the Datapoint class.
 * This class works with float values.
 */
class FloatDataPoint extends DataPoint {
    private Float value = null;

    public FloatDataPoint(String label, boolean isOutput){

        super(label, isOutput);
    }

    public void setValue(Float newValue){
        // Vérifier si la nouvelle valeur est différente de l'ancienne
        if (this.value == null || !this.value.equals(newValue)) {
            this.value = newValue;
            update(true);
        }
    }

    public Float getValue(){
        return value;
    }

    public String toString(){
        return "label = " + label +"\n"
                + "isOutput = " + isOutput + "\n"
                + "value = " + value;
    }
}

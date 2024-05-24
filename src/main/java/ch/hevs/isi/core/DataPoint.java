package ch.hevs.isi.core;

import ch.hevs.isi.db.DataBaseConnector;
import ch.hevs.isi.field.FieldConnector;
import ch.hevs.isi.web.WebConnector;

import java.util.HashMap;
import java.util.Map;

public abstract class DataPoint {

    //Attributs
    protected String label;
    static protected Map<String, DataPoint> dataPointMap = new HashMap<>();
    protected boolean isOutput;

    //Constructeur
    public DataPoint(String label) {
        this.label = label;
        this.dataPointMap.put(label, this); // Ajoute le DataPoint dans la Map avec son label comme clé
        this.isOutput = false;
    }

    //Méthodes
    public void update(boolean isNewValue){
        // Notify all connectors
        DataBaseConnector.getInstance().oneNewValue(this);
        FieldConnector.getInstance().oneNewValue(this);
        WebConnector.getInstance().oneNewValue(this);
    }
    public static DataPoint getDataPointFromLabel(String label) {
        return dataPointMap.get(label);
    }
    public String getLabel() {
        return label;
    }
    public void isOutput(boolean isOutput) {
        this.isOutput = isOutput;
    }

}

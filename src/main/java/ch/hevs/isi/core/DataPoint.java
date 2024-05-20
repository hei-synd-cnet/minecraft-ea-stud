package ch.hevs.isi.core;

import java.util.HashMap;
import java.util.Map;

public class DataPoint {

    //Attributs
    protected String label;
    protected Map<String, DataPoint> dataPointMap;
    protected boolean isOutput;

    //Constructeur
    public DataPoint(String label) {
        this.label = label;
        this.dataPointMap = new HashMap<>();
        this.isOutput = false;
    }

    //Méthodes
    public void update(boolean isNewValue){
    }
    public String getLabel() {
        return label;
    }
    public Map<String, DataPoint> getDataPointMap() {
        return dataPointMap;
    }
    public void setIsOutput(boolean isOutput) {
        this.isOutput = isOutput;
    }

}

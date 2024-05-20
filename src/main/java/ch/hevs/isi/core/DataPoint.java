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
    public DataPoint getDataPointFromLabel(String label) {
        //QUESTION  Vérifie si la map contient une correspondance pour le label donné ?
        return dataPointMap.get(label);
    }
    public String getLabel() {
        return label;
    }
    public void setIsOutput(boolean isOutput) {
        this.isOutput = isOutput;
    }


    //Main Method for Testing DataPoint Class
    public static void main(String[] args) {
        // Create some dataPoint object
        DataPoint d1 = new DataPoint("MyDataPoint");
        FloatDataPoint f1 = new FloatDataPoint("MyFloatingDataPoint",2.5f);
        BooleanDataPoint b1 = new BooleanDataPoint("MyBooleanDataPoint",false);

        //DataPoint 1
        System.out.println("The label of d1 is : " + d1.label + " and the output of d1 is " + d1.isOutput);
        d1.setIsOutput(true);
        d1.label = "Toto";
        System.out.println("The label of d1 is : " + d1.label + " and the output of d1 is " + d1.isOutput + "\n");

        //Floating DataPoint 1
        System.out.println("The label of f1 is : " + f1.label + " , the output of f1 is " + f1.isOutput + " and the value of f1 is " + f1.getValue());
        f1.label = "chat";
        f1.setValue(33.3333f);
        f1.setIsOutput(true);
        System.out.println("The label of f1 is : " + f1.label + " , the output of f1 is " + f1.isOutput + " and the value of f1 is " + f1.getValue() +"\n");

        //Boolean DataPoint 1
        System.out.println("The label of b1 is : " + b1.label + " , the output of b1 is " + b1.isOutput + " and the value of b1 is " + b1.getValue());
        b1.label = "boolean DataPoint Change";
        b1.setValue(true);
        System.out.println("The label of b1 is : " + b1.label + " , the output of b1 is " + f1.isOutput + " and the value of b1 is " + b1.getValue());
    }
}

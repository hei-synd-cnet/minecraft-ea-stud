package ch.hevs.isi.core;
import java.util.HashMap;
import java.util.Map;
 abstract class DataPoint {
     private Map<String, DataPoint> dataPointMap = new HashMap<>();
     private String label;
     private Boolean isOutput;

     protected void DataPoint(String label, Boolean isOutput) {
         this.label = label;
         this.isOutput = isOutput;
     }

     protected void update(Boolean isNewValue){

     }

     public DataPoint getDataPointMapFromLabel(String label) {
         return this.dataPointMap.get(label);
     }

     public String getLabel() {
         return label;
     }

     public Boolean isOutput() {
         return isOutput;
     }
 }

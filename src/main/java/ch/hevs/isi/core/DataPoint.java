package ch.hevs.isi.core;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
 public abstract class DataPoint {
     private static Map<String, DataPoint> dataPointMap = new HashMap<>();
     private String label;
     private Boolean isOutput;
     private static List<DataPointListener> listeners = new ArrayList<>();

     protected DataPoint(String label, Boolean isOutput) {
         this.label = label;
         this.isOutput = isOutput;
         addDataPoint(label,this);
     }

     public static DataPoint getDataPointFromLabel(String label) {
         return dataPointMap.get(label);
     }

     public String getLabel() {
         return label;
     }

     public Boolean isOutput() {
         return isOutput;
     }

     // Méthode pour ajouter un DataPoint à la carte
     private void addDataPoint(String label, DataPoint dataPoint) {this.dataPointMap.put(label, dataPoint);}

     // Méthode pour ajouter un listener
     public static void addListener(DataPointListener listener) {
         listeners.add(listener);
     }

     // Méthode pour supprimer un listener
     public void removeListener(DataPointListener listener) {
         listeners.remove(listener);
     }

     // Méthode pour notifier tous les listeners
     protected void update() {
         for (DataPointListener listener : listeners) {
             listener.onNewValue(this);
         }
     }
 }

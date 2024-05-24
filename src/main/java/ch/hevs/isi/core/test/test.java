package ch.hevs.isi.core.test;

import ch.hevs.isi.core.BooleanDataPoint;
import ch.hevs.isi.core.DataPointListener;
import ch.hevs.isi.core.DataPoint;
import ch.hevs.isi.core.FloatDataPoint;

import ch.hevs.isi.db.DataBaseConnector;
import ch.hevs.isi.web.WebConnector;
import ch.hevs.isi.field.FieldConnector;

public class test {
    public static void main(String[] args) {
        //add singleton listener
        DataPoint.addListener((DataPointListener) DataBaseConnector.getInstance());
        DataPoint.addListener((DataPointListener) WebConnector.getInstance());
        DataPoint.addListener((DataPointListener) FieldConnector.getInstance());
        // Création de BooleanDataPoint
        BooleanDataPoint dp1 = new BooleanDataPoint("DataPoint1", true);

        // Affichage des valeurs initiales
        System.out.println("Initial value of " + dp1.getLabel() + ": " + dp1.getValue());

        // Modification de la valeur
        dp1.setValue(true);
        dp1.setValue(false);

        BooleanDataPoint dp2 = new BooleanDataPoint("DataPoint2", false);

        // Affichage des valeurs initiales
        System.out.println("Initial value of " + dp2.getLabel() + ": " + dp2.getValue());

        dp2.setValue(true);
        dp2.setValue(false);

        DataPoint retrievedDataPoint = DataPoint.getDataPointFromLabel("DataPoint1");
        System.out.println("Retrieved DataPoint: " + retrievedDataPoint);

        //Write on DataPoint
        if(retrievedDataPoint instanceof BooleanDataPoint ){
            ((BooleanDataPoint) retrievedDataPoint).setValue(true);
        } else if (retrievedDataPoint instanceof FloatDataPoint ) {
            ((FloatDataPoint) retrievedDataPoint).setValue(0.2F);
        }

        // Création de flaotDataPoint
        FloatDataPoint dp3 = new FloatDataPoint("solar", true);

        // Modification de la valeur
        dp3.setValue(9);
        dp3.setValue(3);
        dp3.setValue(3);

        // Récupération d'un DataPoint à partir du label (ajouté au map pour test)
        DataPoint retrievedDataPoint3 = DataPoint.getDataPointFromLabel("solar");
        System.out.println("Retrieved DataPoint solar panel: " + retrievedDataPoint3);

        //Write on DataPoint
        if(retrievedDataPoint3 instanceof BooleanDataPoint ){
            ((BooleanDataPoint) retrievedDataPoint3).setValue(true);
        } else if (retrievedDataPoint3 instanceof FloatDataPoint ) {
            ((FloatDataPoint) retrievedDataPoint3).setValue(0.2F);
        }
fdfdf

    }


}

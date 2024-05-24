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

        // Création de BooleanDataPoint
        BooleanDataPoint dp1 = new BooleanDataPoint("DataPoint1", true);
        dp1.addListener((DataPointListener) DataBaseConnector.getInstance());

        // Affichage des valeurs initiales
        System.out.println("Initial value of " + dp1.getLabel() + ": " + dp1.getValue());

        // Modification de la valeur
        dp1.setValue(true);
        dp1.setValue(false);

        // Création d'un autre BooleanDataPoint
        BooleanDataPoint dp2 = new BooleanDataPoint("DataPoint2", false);
        dp2.addListener((DataPointListener) WebConnector.getInstance());

        // Affichage des valeurs initiales
        System.out.println("Initial value of " + dp2.getLabel() + ": " + dp2.getValue());

        // Modification de la valeur
        dp2.setValue(true);

        // Récupération d'un DataPoint à partir du label (ajouté au map pour test)
        dp1.addDataPoint("PowerMAX : ", dp2);
        DataPoint retrievedDataPoint = dp1.getDataPointMapFromLabel("PowerMAX : ");
        System.out.println("Retrieved DataPoint: " + retrievedDataPoint);

        // Création de flaotDataPoint
        FloatDataPoint dp3 = new FloatDataPoint("DataPoint1", true);
        dp3.addListener((DataPointListener) FieldConnector.getInstance());

        // Modification de la valeur
        dp3.setValue(9);
        dp3.setValue(3);
        dp3.setValue(3);

        //test

        // Récupération d'un DataPoint à partir du label (ajouté au map pour test)
        dp3.addDataPoint("solar panel value : ", dp3);
        DataPoint retrievedDataPoint3 = dp3.getDataPointMapFromLabel("solar panel value : ");
        System.out.println("Retrieved DataPoint solar panel: " + retrievedDataPoint3);



    }


}

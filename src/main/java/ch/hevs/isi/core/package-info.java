package ch.hevs.isi.core;
import java.util.HashMap;
import java.util.Map;

// Core Classes

abstract class DataPoint {
    protected String label;
    protected boolean isOutput;

    public DataPoint(String label, boolean isOutput) {
        this.label = label;
        this.isOutput = isOutput;
    }

    public abstract void update(boolean isNewValue);

    public String getLabel() {
        return label;
    }

    public boolean isOutput() {
        return isOutput;
    }

    public static DataPoint getDataPointFromLabel(String label, Map<String, DataPoint> dataPointMap) {
        return dataPointMap.get(label);
    }
}

class BooleanDataPoint extends DataPoint {
    private boolean value;

    public BooleanDataPoint(String label, boolean isOutput) {
        super(label, isOutput);
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public void update(boolean isNewValue) {
        this.value = isNewValue;
    }

    @Override
    public String toString() {
        return "BooleanDataPoint{" +
                "label='" + label + '\'' +
                ", isOutput=" + isOutput +
                ", value=" + value +
                '}';
    }
}

class FloatDataPoint extends DataPoint {
    private float value;

    public FloatDataPoint(String label, boolean isOutput) {
        super(label, isOutput);
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public void update(boolean isNewValue) {
        // Assuming we have some way to convert boolean to float, for this example, just set to 1.0f if true, else 0.0f
        this.value = isNewValue ? 1.0f : 0.0f;
    }

    @Override
    public String toString() {
        return "FloatDataPoint{" +
                "label='" + label + '\'' +
                ", isOutput=" + isOutput +
                ", value=" + value +
                '}';
    }
}

// Singleton Connectors

class DatabaseConnector {
    private static DatabaseConnector instance;

    private DatabaseConnector() {
    }

    public static DatabaseConnector getInstance() {
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }

    public void initialize(String url, String... params) {
        // Initialize database connection here
    }

    public void pushToDatabase(DataPoint dp) {
        // Stub method to simulate pushing to database
        System.out.println("Pushing to Database: " + dp);
    }
}

class FieldConnector {
    private static FieldConnector instance;

    private FieldConnector() {
    }

    public static FieldConnector getInstance() {
        if (instance == null) {
            instance = new FieldConnector();
        }
        return instance;
    }

    public void initialize(String host, int port) {
        // Initialize field connection here
    }

    public void pushToField(DataPoint dp) {
        // Stub method to simulate pushing to field
        System.out.println("Pushing to Field: " + dp);
    }
}

class WebConnector {
    private static WebConnector instance;

    private WebConnector() {
    }

    public static WebConnector getInstance() {
        if (instance == null) {
            instance = new WebConnector();
        }
        return instance;
    }

    public void initialize(String host, int port) {
        // Initialize web connection here
    }

    public void pushToWeb(DataPoint dp) {
        // Stub method to simulate pushing to web
        System.out.println("Pushing to Web: " + dp);
    }
}

// Listener Interface

interface DataPointListener {
    void onNewValue(DataPoint dp);
}
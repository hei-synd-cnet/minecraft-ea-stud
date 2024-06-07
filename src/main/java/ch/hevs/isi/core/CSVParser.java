package ch.hevs.isi.core;


import ch.hevs.isi.utils.Utility;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    public static void main(String[] args) {
        BufferedReader csv = Utility.fileParser("csv", "ModbusMap.csv");
        List<DataPoint> datapoints = new ArrayList<>();
        String line = null;

        try {
            line = csv.readLine();
            while (line != null) {

                String[] val = line.split(";");
                line = csv.readLine();

                String label = val[0];
                String type = val[1];
                boolean input = val[2].equalsIgnoreCase("Y");
                boolean output = val[3].equalsIgnoreCase("Y");
                int address = Integer.parseInt(val[4]);
                int range = Integer.parseInt(val[5]);
                int offset = Integer.parseInt(val[6]);


                if (type.equalsIgnoreCase("F")) {
                    DataPoint fr = new FloatDataPoint(label, address, range, offset);//Prendre FloatRegister eBooleanRegister
                    datapoints.add(fdp);
                } else if (type.equalsIgnoreCase("B")) {
                    BooleanDataPoint bdp = new BooleanDataPoint(label, address, range, offset);
                    datapoints.add(bdp);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

package ch.hevs.isi.core;

import ch.hevs.isi.field.BooleanRegister;
import ch.hevs.isi.field.FloatRegister;
import ch.hevs.isi.utils.Utility;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * This class is responsible for parsing a CSV file and creating data points
 * based on the information read from the file.
 */
public class CSVParser {

    /**
     * Reads a CSV file and creates data points based on the file's content.
     */
    public static void creatDatapoint() {

        BufferedReader csv = Utility.fileParser("csv", "ModbusMap.csv");
        String line = null;

        try {
            line = csv.readLine();
            line = csv.readLine(); // Skip the first line as it is not needed for creating data points

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
                    /**
                     * Create the FloatRegister
                     */
                    new FloatRegister(label, output, address, range, offset);
                } else if (type.equalsIgnoreCase("B")) {
                    /**
                     * Create the BooleanDataPoint
                     */
                    new BooleanRegister(label, output, address);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
package ch.hevs.isi.core;

import ch.hevs.isi.field.BooleanRegister;
import ch.hevs.isi.field.FloatRegister;
import ch.hevs.isi.utils.Utility;
import java.io.BufferedReader;
import java.io.IOException;

public class CSVParser {
    /**Public Class from, read the CVS file*/

    public static void creatDatapoint(){


        BufferedReader csv = Utility.fileParser("csv", "ModbusMap.csv");
        String line = null;

        try {
            line = csv.readLine();
            line = csv.readLine();//First Line useless for create Datapoint

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
                    new FloatRegister(label,output, address, range, offset);//Prendre FloatRegister et BooleanRegister (voir fichier Prendre code Field)

                } else if (type.equalsIgnoreCase("B")) {
                    new BooleanRegister(label, output, address);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

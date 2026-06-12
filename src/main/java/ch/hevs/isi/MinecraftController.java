package ch.hevs.isi;

import ch.hevs.isi.utils.Utility;

public class MinecraftController {

    public static boolean ERASE_PREVIOUS_DATA_INB_DB        = false;

    public static void usage() {
        System.out.println();
        System.out.println("You're reading this message because no parameter (or not the needed ones) has been passed to the application.");
        System.out.println();
        System.out.println("In development mode, just add to your running configuration the needed parameters (see usage below).");
        System.out.println("In running mode, the application's usage is the following:");
        System.out.println("java MinecraftController <InfluxDB Hostname> <DB Organisation> <DB Bucket> <DB Measurement> <DB Token> <ModbusTCP Hostname> <ModbusTCP port> [-eraseDB]");
        System.out.println("where:");
        System.out.println("- <InfluxDB Hostname>:  The complete URL of the InfluxDB server, including the protocol (http or https)...");
        System.out.println("                        Example: https://influx.cnet.synd.hevs.ch");
        System.out.println("- <DB Organisation>:    The name of the organisation to use with InfluxDB v 2.X.X. For this project, this name is the group's name you've been affected to. (cnetXX)");
        System.out.println("- <DB Bucket>:          The name of the bucket to use with InfluxDB v 2.X.X.");
        System.out.println("- <DB Measurement>:     The name of the measurement to be used to store data in InfluxDB.  (default value: minecraft)");
        System.out.println("- <DB Token>:           The user's token giving access the DB. You can find it on https://influx.cnet.synd.hevs.ch and looking for `API Token` ...");
        System.out.println("- <ModbusTCP Hostname>: The IP address of the Minecraft ModbusTCP server (default value: localhost)");
        System.out.println("- <ModbusTCP port>:     The port number of the Minecraft ModbusTCP server (default value: 1502)");
        System.out.println("- [-eraseDB]:           Optional parameter! If set, the application should erase the previous data in InfluxDB (if you've implemented the feature)...");
        System.out.println();
        System.out.println("Be aware that for now on, the default values are used !");
        System.out.println("Edit your configuration to set up your parameters !");
        System.out.println();
        System.out.println();
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {

        // ------------------------------------- DO NOT CHANGE THE FOLLOWING LINES -------------------------------------
        String dbProtocol       = "https";
        String dbHostName       = "influx.cnet.synd.hevs.ch";
        String dbOrganisation   = "cnetXX";
        String dbBucket         = "cnet";
        String dbMeasurement    = "minecraft";
        String dbToken          = "_your_token_";

        String modbusTcpHost    = "localhost";
        int modbusTcpPort       = 1502;

        // Check the number of arguments and show usage message if the number does not match.
        String[] parameters;

        // If there is only one number given as parameter, construct the parameters according the group number.
        if (args.length > 6) {
            parameters = args;

            // Decode parameters for influxDB
            String[] dbParams = parameters[0].split("://");
            if (dbParams.length != 2) {
                usage();
            }

            dbProtocol      = dbParams[0];
            dbHostName      = dbParams[1];
            dbOrganisation  = parameters[1];
            dbBucket        = parameters[2];
            dbMeasurement   = parameters[3];
            dbToken         = parameters[4];

            // Decode parameters for Modbus TCP
            modbusTcpHost = parameters[5];
            modbusTcpPort = Integer.parseInt(parameters[6]);

            for (int i = 7; i < args.length; i++) {
                if (parameters[i].compareToIgnoreCase("-erasedb") == 0) {
                    ERASE_PREVIOUS_DATA_INB_DB = true;
                    continue;
                }
            }
        } else {
            usage();
        }
        // ------------------------------------ /DO NOT CHANGE THE FOLLOWING LINES -------------------------------------

        // TODO: write your main code here. Have fun !

    }
}

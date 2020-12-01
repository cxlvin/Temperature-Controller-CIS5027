import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SensorData
{

    String id;
    String lightLevel;
    String temperature;



    public static void main(String[] args)
    {

        //initiate delay + filename vars
        int delay = 1000;
        String filename = "sensor_data.csv";

        // check and assign args, parse from String to integer for delay
        if (args.length > 0) {
            try {
                delay = Integer.parseInt(args[0]);
                filename = args[1];
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + "must be an integer.");
                System.exit(1);
            }
        }

        // debug arg logs
        System.out.println("Args count: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + i + ": " + args[i]);
        }

        // instantiate SensorData object
        SensorData mySens = new SensorData();

        // declare properties
        String line = "";
        String delim = ",";


        // parse CSV file
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] tempData = line.split(delim);    // uses comma as separator

                mySens.id = tempData[0];
                mySens.lightLevel = tempData[7];
                mySens.temperature = tempData[9];

                //concatenates & prints object holding ID, light level and temperature level
                System.out.println("ID: " + mySens.id + " | " + "Light level: " + mySens.lightLevel + " | " + "Temperature: " + mySens.temperature);
                Thread.sleep(delay);
            }
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
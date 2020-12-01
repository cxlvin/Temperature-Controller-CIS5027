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
    SensorData mySens = new SensorData();


        //declare properties
        String line = "";
        String delim = ",";

        try
        {
            //parsing CSV file into BufferedReader
            BufferedReader br = new BufferedReader(new FileReader("sensor_data.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] tempData = line.split(delim);    // uses comma as separator

                mySens.id = tempData[0];
                mySens.lightLevel = tempData[7];
                mySens.temperature = tempData[9];

                //concatenates & prints object holding ID, light level and temperature level
                System.out.println("ID: " + mySens.id + " | " + "Light level: " + mySens.lightLevel + " | " + "Temperature: " + mySens.temperature);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
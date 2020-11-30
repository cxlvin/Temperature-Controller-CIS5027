import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class SensorData
{
    public static void main(String[] args)
    {
        String line = "";
        String delim = ",";

        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("sensor_data.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {

                String[] tempData = line.split(delim);    // use comma as separator
                System.out.println("ID " + tempData[0] + ", Light level=" + tempData[7] + ", Temperature=" + tempData[9]);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
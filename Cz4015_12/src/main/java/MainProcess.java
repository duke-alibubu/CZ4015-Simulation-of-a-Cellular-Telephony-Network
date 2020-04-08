import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import main.init.StationListContainer;
import main.system.Car;
import utils.enums.FCAScheme;

import java.io.FileReader;
import java.util.List;

public class MainProcess {
    private final static String FILE_PATH = "D:/My Folder/Academic/Year 3 Sem 2/CZ4015 Simulation & Modeling/Assignment/Cz4015_12/src/main/resources/PCS_TEST_DETERMINSTIC_19S2.csv";
    public static void main(String[] args){
        StationListContainer stationListContainer = new StationListContainer(FCAScheme.One_Channel_Reversed_For_Handovers);
        loadCarDataFromCSVFile();
    }

    private static void loadCarDataFromCSVFile(){
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(FILE_PATH);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            for (String[] row : allData) {
                double arrivalTime = Double.parseDouble(row[1]);
                int baseStation = Integer.parseInt(row[2]);
                double callDuration = Double.parseDouble(row[3]);
                double velocity = Double.parseDouble(row[4]);
                Car car = new Car(arrivalTime, baseStation, callDuration, velocity);
                System.out.println(car.toString());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

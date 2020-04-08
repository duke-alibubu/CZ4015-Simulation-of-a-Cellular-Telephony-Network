package test;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import main.init.StationListContainer;
import utils.enums.FCAScheme;
import utils.generators.InitialPositionGenerator;

import java.io.FileReader;
import java.util.List;

public class Test {
    public static void main(String[] args){
        int numLeft = 0;
        int numRight = 0;
        int total = 0;


        // TEST DIRECTION
//        for (int i = 0; i < 10000000; i++){
//            if (DirectionGenerator.generateDirection() == Direction.Right)
//                numRight++;
//            else numLeft++;
//        }
//        System.out.println(numRight);
//        System.out.println(numLeft);


        // TEST INITIAL POSITION
//        InitialPositionGenerator  initialPositionGenerator = new InitialPositionGenerator();
//        for (int i = 0; i < 200000; i++)
//            total += initialPositionGenerator.generateInitialPosition();
//        System.out.println(total/200000);

        // TEST GENERATE STATION
//        StationListContainer stationListContainer = new StationListContainer(FCAScheme.One_Channel_Reversed_For_Handovers);
//        System.out.println(StationListContainer.stationList.get(0).numAvailableFreeChannels);
//        System.out.println(StationListContainer.stationList.get(0).maxChannelsReservedForHandover);
//        System.out.println(StationListContainer.stationList.get(0).numChannelsReservedForHandover);
        String filepath = "D:/My Folder/Academic/Year 3 Sem 2/CZ4015 Simulation & Modeling/Assignment/Cz4015_12/src/main/resources/PCS_TEST_DETERMINSTIC_19S2.csv";
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(filepath);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            // print Data
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell);
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

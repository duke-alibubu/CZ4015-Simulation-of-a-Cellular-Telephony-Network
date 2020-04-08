package simulation.init;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import simulation.system.Call;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CallListContainer {
    private final static String FILE_PATH = "D:/My Folder/Academic/Year 3 Sem 2/CZ4015 Simulation & Modeling/Assignment/Cz4015_12/src/main/resources/PCS_TEST_DETERMINSTIC_19S2.csv";
    private final static int NUMBER_OF_CALLS = 250000;
    private static List<Call> callList;
    private Random arrivalTimeGenerator;
    private Random baseStationGenerator;
    private Random callDurationGenerator;
    private Random velocityGenerator;

    public CallListContainer(boolean isAutoGenerate){
        if (!isAutoGenerate){
            callList = new ArrayList<Call>();
            loadCallDataFromCSVFile();
        }
        else {
            callList = new ArrayList<Call>(NUMBER_OF_CALLS);
            arrivalTimeGenerator = new Random();
            baseStationGenerator = new Random();
            callDurationGenerator = new Random();
            velocityGenerator = new Random();
            generateCallList();
        }
    }

    public static List<Call> getCallList() {
        return callList;
    }
    private void loadCallDataFromCSVFile(){
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
                Call call = new Call(arrivalTime, baseStation, callDuration, velocity);
                callList.add(call);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateCallList(){
        for (int i = 0; i < NUMBER_OF_CALLS; i++){
            callList.add(new Call(arrivalTimeGenerator.nextDouble() * 100000, baseStationGenerator.nextInt(20) + 1, callDurationGenerator.nextDouble() * 180, velocityGenerator.nextDouble() * 130));
        }
        System.out.println(callList.toString());
    }
}

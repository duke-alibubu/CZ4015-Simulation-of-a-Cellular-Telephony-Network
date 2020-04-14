package simulation.containers;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import simulation.MainProcess;
import simulation.system.Call;
import utils.enums.Direction;
import utils.generators.ArrivalTimeGenerator;
import utils.generators.BaseStationGenerator;
import utils.generators.CallDurationGenerator;
import utils.generators.VelocityGenerator;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CallListContainer {
    private final static String FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/input/PCS_TEST_DETERMINSTIC_19S2.csv";
    private final static int NUMBER_OF_CALLS = 250000;
    private List<Call> callList;

    public CallListContainer(boolean isAutoGenerate){
        if (!isAutoGenerate){
            callList = new ArrayList<Call>();
            loadCallDataFromCSVFile();
        }
        else {
            callList = new ArrayList<Call>(NUMBER_OF_CALLS);
            generateCallList();
        }
    }

    public List<Call> getCallList() {
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
                Direction direction = MainProcess.directionGenerator.generateDirection();
                Call call = new Call(arrivalTime, baseStation, callDuration, velocity, direction);
                callList.add(call);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateCallList(){
        for (int i = 0; i < NUMBER_OF_CALLS; i++){
            double arrivalTime = MainProcess.arrivalTimeGenerator.generateArrivalTime();
            int baseStation = MainProcess.baseStationGenerator.generateBaseStation();
            double callDuration = MainProcess.callDurationGenerator.generateCallDuration();
            double velocity = MainProcess.velocityGenerator.generateVelocity();
            Direction direction = MainProcess.directionGenerator.generateDirection();
            callList.add(new Call(arrivalTime, baseStation, callDuration, velocity, direction));
        }
    }
}

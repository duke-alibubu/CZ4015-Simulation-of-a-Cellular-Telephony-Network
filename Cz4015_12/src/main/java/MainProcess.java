import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import simulation.init.CallListContainer;
import simulation.init.StationListContainer;
import utils.enums.FCAScheme;

import java.io.FileReader;
import java.util.List;

public class MainProcess {
    private final static String FILE_PATH = "D:/My Folder/Academic/Year 3 Sem 2/CZ4015 Simulation & Modeling/Assignment/Cz4015_12/src/main/resources/PCS_TEST_DETERMINSTIC_19S2.csv";
    public static void main(String[] args){
        StationListContainer stationListContainer = new StationListContainer(FCAScheme.One_Channel_Reversed_For_Handovers);
        CallListContainer callListContainer = new CallListContainer(true);
    }

}

package simulation;

import simulation.init.CallListContainer;
import simulation.init.StationListContainer;
import utils.enums.FCAScheme;

public class MainProcess {
    public static int simulationClock = 0;
    public static int numTotal = 0;
    public static int numDropped = 0;
    public static int numBlocked = 0;
    public static void main(String[] args){
        StationListContainer stationListContainer = new StationListContainer(FCAScheme.One_Channel_Reversed_For_Handovers);
        CallListContainer callListContainer = new CallListContainer(true);

    }
}

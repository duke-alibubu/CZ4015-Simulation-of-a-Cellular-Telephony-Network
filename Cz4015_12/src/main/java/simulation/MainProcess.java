package simulation;

import simulation.events.CallEventAbstractClass;
import simulation.init.CallListContainer;
import simulation.init.StationListContainer;
import utils.enums.FCAScheme;

import java.util.PriorityQueue;

public class MainProcess {
    public static double simulationClock = 0;
    public static int numTotal = 0;
    public static int numDropped = 0;
    public static int numBlocked = 0;
    public static PriorityQueue<CallEventAbstractClass> futureEventList;
    public static void main(String[] args){
        StationListContainer stationListContainer = new StationListContainer(FCAScheme.One_Channel_Reversed_For_Handovers);
        CallListContainer callListContainer = new CallListContainer(true);

    }
}

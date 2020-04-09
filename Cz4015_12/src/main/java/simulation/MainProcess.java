package simulation;

import simulation.events.CallEventAbstractClass;
import simulation.events.CallInitiationEvent;
import simulation.init.CallListContainer;
import simulation.init.StationListContainer;
import simulation.system.Call;
import utils.enums.FCAScheme;

import java.util.PriorityQueue;

public class MainProcess {
    public static double simulationClock = 0;
    public static int numTotal = 0;
    public static int numDropped = 0;
    public static int numBlocked = 0;
    public static PriorityQueue<CallEventAbstractClass> futureEventList = new PriorityQueue<CallEventAbstractClass>();
    public static void main(String[] args){
        StationListContainer stationListContainer = new StationListContainer(FCAScheme.No_Channel_Reservation);
        CallListContainer callListContainer = new CallListContainer(true);
        for (Call call: callListContainer.getCallList()){
            futureEventList.add(new CallInitiationEvent(call, call.getArrivalTime()));
        }
        while (!futureEventList.isEmpty()){
            CallEventAbstractClass nextEvent = futureEventList.poll();
            nextEvent.execute();
        }
        System.out.println(numDropped);
        System.out.println(numBlocked);
        System.out.println(numTotal);
    }
}

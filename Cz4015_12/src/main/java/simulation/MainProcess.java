package simulation;

import simulation.events.CallEventAbstractClass;
import simulation.events.CallInitiationEvent;
import simulation.init.CallListContainer;
import simulation.init.StationListContainer;
import simulation.system.Call;
import utils.calculators.OutputCalculator;
import utils.enums.FCAScheme;
import utils.writers.MyCSVWriter;

import java.util.PriorityQueue;

public class MainProcess {
    public static double simulationClock = 0;
    public static int numTotal = 0;
    public static int numDropped = 0;
    public static int numBlocked = 0;
    public static PriorityQueue<CallEventAbstractClass> futureEventList = new PriorityQueue<CallEventAbstractClass>();
    private static MyCSVWriter myCSVWriter;
    public static void main(String[] args){
        StationListContainer stationListContainer = new StationListContainer(FCAScheme.Nine_Channel_Reversed_For_Handovers);
        myCSVWriter = new MyCSVWriter(StationListContainer.getFCASchemeName());
        CallListContainer callListContainer = new CallListContainer(true);
        for (Call call: callListContainer.getCallList()){
            futureEventList.add(new CallInitiationEvent(call, call.getArrivalTime()));
        }
        while (!futureEventList.isEmpty()){
            CallEventAbstractClass nextEvent = futureEventList.poll();
            nextEvent.execute();
        }
        System.out.println("Final Result: ");
        System.out.println("Dropped Rate: " + OutputCalculator.calculateOutPutPercentage(numDropped, numTotal) + " %");
        System.out.println("Blocked Rate: " +OutputCalculator.calculateOutPutPercentage(numBlocked, numTotal) + " %");

        myCSVWriter.closeCSVWriter();
    }

    public static void updateCSVOutput(){
        myCSVWriter.writeDataToCSV(OutputCalculator.calculateOutPutPercentage(numDropped, numTotal), OutputCalculator.calculateOutPutPercentage(numBlocked, numTotal), simulationClock);
    }
}

package simulation;

import simulation.events.CallEventAbstractClass;
import simulation.events.CallInitiationEvent;
import simulation.containers.CallListContainer;
import simulation.containers.StationListContainer;
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
    public static int numWarmUpCalls = 100000;
    public static int numTotalAfterWarmUp = 0;
    public static int numDroppedAfterWarmUp = 0;
    public static int numBlockedAfterWarmUp = 0;
    private static MyCSVWriter outputAnalysisWriter;
    private static int numberOfRun = 200;
    public static void main(String[] args){
        outputAnalysisWriter = new MyCSVWriter(String.valueOf(numberOfRun) + "_Run");

        for (int i = 0; i < numberOfRun; i++){
            resetSystemCount();
            StationListContainer stationListContainer = new StationListContainer(FCAScheme.No_Channel_Reservation);
            CallListContainer callListContainer = new CallListContainer(true);
            myCSVWriter = new MyCSVWriter(StationListContainer.getFCASchemeName(), "Full_run");
            for (Call call: callListContainer.getCallList()){
                futureEventList.add(new CallInitiationEvent(call, call.getArrivalTime()));
            }
            while (!futureEventList.isEmpty()){
                CallEventAbstractClass nextEvent = futureEventList.poll();
                nextEvent.execute();
            }

            outputAnalysisWriter.writeDataToCSV(OutputCalculator.calculateOutPutPercentage(numDroppedAfterWarmUp, numTotalAfterWarmUp), OutputCalculator.calculateOutPutPercentage(numBlockedAfterWarmUp, numTotalAfterWarmUp));
            myCSVWriter.closeCSVWriter();
        }
        outputAnalysisWriter.closeCSVWriter();
    }

    public static void updateCSVOutput(){
        myCSVWriter.writeDataToCSV(OutputCalculator.calculateOutPutPercentage(numDropped, numTotal), OutputCalculator.calculateOutPutPercentage(numBlocked, numTotal), numTotal);
    }

    public static void resetSystemCount(){
        numTotal = 0;
        numTotalAfterWarmUp = 0;
        numDropped = 0;
        numDroppedAfterWarmUp = 0;
        numBlocked = 0;
        numBlockedAfterWarmUp = 0;
    }
}

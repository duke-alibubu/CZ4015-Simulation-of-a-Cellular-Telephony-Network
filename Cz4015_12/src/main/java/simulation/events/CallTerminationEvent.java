package simulation.events;

import simulation.MainProcess;
import simulation.containers.StationListContainer;
import simulation.system.Call;
import simulation.system.Station;

public class CallTerminationEvent extends CallEventAbstractClass{
    private Call call;
    private double timeSpent;
    public CallTerminationEvent (Call call, double timeSpent, double procTime){
        this.call = call;
        this.timeSpent = timeSpent;
        this.procTime = procTime;
    }

    public void execute() {
        MainProcess.simulationClock = procTime;
        call.callDuration -= timeSpent;
        Station previousStation = StationListContainer.getStationList().get(call.baseStation - 1);
        if (previousStation.numChannelsReservedForHandover < previousStation.getMaxChannelsReservedForHandover())
            previousStation.numChannelsReservedForHandover++;
        else
            previousStation.numAvailableFreeChannels++;

        MainProcess.numTotal++;
        MainProcess.updateCSVOutput();

        if (MainProcess.numWarmUpCalls > 0){
            MainProcess.numWarmUpCalls--;
        }
        else {
            MainProcess.numTotalAfterWarmUp++;
        }
    }
}

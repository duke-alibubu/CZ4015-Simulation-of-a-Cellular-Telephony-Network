package simulation.events;

import simulation.MainProcess;
import simulation.init.StationListContainer;
import simulation.system.Call;
import simulation.system.Station;

public class CallTerminationEvent extends CallEventAbstractClass{
    private Call call;
    private double timeSpent;
    public CallTerminationEvent (Call call, double timeSpent){
        this.call = call;
        this.timeSpent = timeSpent;
    }

    public void execute() {
        call.callDuration -= timeSpent;
        Station previousStation = StationListContainer.getStationList().get(call.baseStation - 1);
        if (previousStation.numChannelsReservedForHandover < previousStation.getMaxChannelsReservedForHandover())
            previousStation.numChannelsReservedForHandover++;
        else
            previousStation.numAvailableFreeChannels++;

        MainProcess.numTotal++;
    }
}

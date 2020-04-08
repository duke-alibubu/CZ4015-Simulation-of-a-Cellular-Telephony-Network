package simulation.events;


import simulation.MainProcess;
import simulation.init.StationListContainer;
import simulation.system.Call;
import simulation.system.Station;
import utils.enums.Direction;

public class CallHandoverEvent implements CallEventInterface{
    private Call call;
    private double timeSpent;
    public CallHandoverEvent (Call call, double timeSpent){
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

        if (call.getDirection() == Direction.Left)
            call.baseStation++;
        else
            call.baseStation--;

        Station thisStation = StationListContainer.getStationList().get(call.baseStation - 1);
        if (thisStation.numAvailableFreeChannels == 0){
            if (thisStation.numChannelsReservedForHandover == 0){
                MainProcess.numDropped++;
                MainProcess.numTotal++;
                return;
            }
            else
                thisStation.numChannelsReservedForHandover--;
        }
        else
            thisStation.numAvailableFreeChannels--;

        double maxCallTime = 7200/call.getVelocity();

        if (call.callDuration <= maxCallTime){
            //FutureEventList.add(new CallTerminationEvent(car, car.CallDuration), simulationClock + car.CallDuration);
        }
        else {
            if ((call.getDirection() == Direction.Left && call.baseStation == 20) || (call.getDirection() == Direction.Right && call.baseStation == 0)){
                //FutureEventList.add(new CallTerminationEvent(car, max_call_time), simulationClock + max_call_time);
            }
            else {
                //FutureEventList.add(new CallHandoverEvent(car, max_call_time), simulationClock + max_call_time);
            }
        }
    }
}

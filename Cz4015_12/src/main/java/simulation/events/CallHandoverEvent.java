package simulation.events;


import simulation.MainProcess;
import simulation.init.StationListContainer;
import simulation.system.Call;
import simulation.system.Station;
import utils.enums.Direction;

public class CallHandoverEvent extends CallEventAbstractClass{
    private Call call;
    private double timeSpent;
    public CallHandoverEvent (Call call, double timeSpent, double procTime){
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

        if (call.getDirection() == Direction.Left)
            call.baseStation++;
        else
            call.baseStation--;

        Station thisStation = StationListContainer.getStationList().get(call.baseStation - 1);
        if (thisStation.numAvailableFreeChannels == 0){
            if (thisStation.numChannelsReservedForHandover == 0){
                MainProcess.numDropped++;
                MainProcess.numTotal++;
                MainProcess.updateCSVOutput();
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
            MainProcess.futureEventList.add(new CallTerminationEvent(call, call.callDuration, MainProcess.simulationClock + call.callDuration));
        }
        else {
            if ((call.getDirection() == Direction.Left && call.baseStation == 20) || (call.getDirection() == Direction.Right && call.baseStation == 1)){
                //FutureEventList.add(new CallTerminationEvent(car, max_call_time), simulationClock + max_call_time);
                MainProcess.futureEventList.add(new CallTerminationEvent(call, maxCallTime, MainProcess.simulationClock + maxCallTime));
            }
            else {
                //FutureEventList.add(new CallHandoverEvent(car, max_call_time), simulationClock + max_call_time);
                MainProcess.futureEventList.add(new CallHandoverEvent(call, maxCallTime, MainProcess.simulationClock + maxCallTime));
            }
        }
    }
}

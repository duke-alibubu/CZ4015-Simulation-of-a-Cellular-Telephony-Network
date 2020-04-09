package simulation.events;

import simulation.MainProcess;
import simulation.init.StationListContainer;
import simulation.system.Call;
import simulation.system.Station;
import utils.enums.Direction;

public class CallInitiationEvent extends CallEventAbstractClass {
    private Call call;
    public CallInitiationEvent (Call call, double procTime){
        this.call = call;
        this.procTime = procTime;
        MainProcess.simulationClock = procTime;
    }

    public void execute() {
        Station station = StationListContainer.getStationList().get(call.baseStation - 1);
        if (station.numAvailableFreeChannels == 0){
            MainProcess.numBlocked++;
            MainProcess.numTotal++;
        }
        else {
            double maxCallTime;
            station.numAvailableFreeChannels--;
            if (call.getDirection() == Direction.Left)
                maxCallTime = (2000 - call.getInitialPosition())/call.getVelocity() * 3.6;
            else
                maxCallTime = call.getInitialPosition()/call.getVelocity() * 3.6;

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
}

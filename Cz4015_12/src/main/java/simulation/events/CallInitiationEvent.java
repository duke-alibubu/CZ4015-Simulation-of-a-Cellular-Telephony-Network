package simulation.events;

import simulation.MainProcess;
import simulation.init.StationListContainer;
import simulation.system.Call;
import simulation.system.Station;
import utils.enums.Direction;

public class CallInitiationEvent implements CallEventInterface {
    private Call call;
    public CallInitiationEvent (Call call){
        this.call = call;
    }

    public void execute() {
        Station station = StationListContainer.getStationList().get(call.getBaseStation() - 1);
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
            }
            else {
                if ((call.getDirection() == Direction.Left && call.getBaseStation() == 20) || (call.getDirection() == Direction.Right && call.getBaseStation() == 0)){
                    //FutureEventList.add(new CallTerminationEvent(car, max_call_time), simulationClock + max_call_time);
                }
                else {
                    //FutureEventList.add(new CallHandoverEvent(car, max_call_time), simulationClock + max_call_time);
                }
            }
        }
    }
}

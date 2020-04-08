package simulation.events;

import simulation.system.Call;

public class CallHandoverEvent extends CallEventInterface{
    private Call call;
    public CallHandoverEvent (Call call){
        this.call = call;
    }

    public void run() {

    }
}

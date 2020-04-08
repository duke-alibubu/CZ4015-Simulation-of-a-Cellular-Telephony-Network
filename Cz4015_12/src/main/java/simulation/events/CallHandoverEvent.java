package simulation.events;

import simulation.system.Call;

public class CallHandoverEvent implements CallEventInterface{
    private Call call;
    public CallHandoverEvent (Call call){
        this.call = call;
    }

    public void execute() {

    }
}

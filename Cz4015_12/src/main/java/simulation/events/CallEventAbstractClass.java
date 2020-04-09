package simulation.events;

public abstract class CallEventAbstractClass implements Comparable<CallEventAbstractClass>{
    protected double procTime;
    public abstract void execute();

    public int compareTo(CallEventAbstractClass event2) {
        return Double.compare(this.procTime, event2.procTime);
    }
}

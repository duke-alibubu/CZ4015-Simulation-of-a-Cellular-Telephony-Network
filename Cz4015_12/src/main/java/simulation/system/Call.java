package simulation.system;

import simulation.containers.StationListContainer;
import utils.enums.Direction;
import utils.generators.DirectionGenerator;

public class Call {
    private double arrivalTime;
    public int baseStation;
    public double callDuration;
    private double velocity;
    private Direction direction;

    //initial position with respect to the leftmost border of the station
    private int initialPosition;

    public Call(double arrivalTime, int baseStation, double callDuration, double velocity) {
        this.arrivalTime = arrivalTime;
        this.baseStation = baseStation;
        this.callDuration = callDuration;
        this.velocity = velocity;
        this.direction = DirectionGenerator.generateDirection();
        this.initialPosition = StationListContainer.getStationList().get(baseStation-1).generateInitialPositionWithinThisStation();
    }

    @Override
    public String toString() {
        return "Car{" +
                "arrivalTime=" + arrivalTime +
                ", baseStation=" + baseStation +
                ", callDuration=" + callDuration +
                ", velocity=" + velocity +
                ", direction=" + direction +
                ", initialPosition=" + initialPosition +
                '}';
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public double getVelocity() {
        return velocity;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getInitialPosition() {
        return initialPosition;
    }
}

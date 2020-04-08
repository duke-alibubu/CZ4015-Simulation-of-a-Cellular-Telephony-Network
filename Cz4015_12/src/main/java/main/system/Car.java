package main.system;

import main.init.StationListContainer;
import utils.enums.Direction;
import utils.generators.DirectionGenerator;

public class Car {
    private double arrivalTime;
    private int baseStation;
    private double callDuration;
    private double velocity;
    private Direction direction;
    private int initialPosition;

    public Car(double arrivalTime, int baseStation, double callDuration, double velocity) {
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
}

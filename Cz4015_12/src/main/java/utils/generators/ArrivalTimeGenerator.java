package utils.generators;

import java.util.Random;

public class ArrivalTimeGenerator {
    private static final double MEAN = 1.3698169264765245;
    private double arrivalTimeCumulator;
    private boolean isFirstTime;
    private Random rand;

    public ArrivalTimeGenerator(){
        arrivalTimeCumulator = 0;
        isFirstTime = true;
        rand = new Random();
    }
    private double generateInterArrivalTime(){
        //Use inverse transform to make a exponentially distributed number with mean provided
        double u = rand.nextDouble();
        return -Math.log(1 - u) * MEAN;
    }
    public double generateArrivalTime(){
        if (isFirstTime){
            isFirstTime = false;
            return 0;
        }
        else {
            arrivalTimeCumulator += generateInterArrivalTime();
            return arrivalTimeCumulator;
        }
    }
}

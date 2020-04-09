package utils.generators;

import java.util.Random;

public class ArrivalTimeGenerator {
    private static final double MEAN = 1.3698169264765245;
    private static double arrivalTimeCumulator = 0;
    private static boolean isFirstTime = true;
    private static Random rand = new Random();

    private static double generateInterArrivalTime(){
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

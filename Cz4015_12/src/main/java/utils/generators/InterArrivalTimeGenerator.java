package utils.generators;

import java.util.Random;

public class InterArrivalTimeGenerator {
    private static final double MEAN = 1.3698169264765245;

    private static Random rand = new Random();

    public static double generateInterArrivalTime(){
        //Use inverse transform to make a exponentially distributed number with mean provided
        double u = rand.nextDouble();
        return -Math.log(1 - u) * MEAN;
    }
}

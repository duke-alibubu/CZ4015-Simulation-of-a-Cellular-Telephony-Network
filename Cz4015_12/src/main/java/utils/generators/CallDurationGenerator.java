package utils.generators;

import java.util.Random;

public class CallDurationGenerator {
    private static final double MEAN = 99.8359007387477;

    private Random rand;

    public CallDurationGenerator(){
        rand = new Random();
    }

    public double generateCallDuration(){
        //Use inverse transform to make a exponentially distributed number with mean provided, plus 10
        double u = rand.nextDouble();
        return -Math.log(1 - u) * MEAN + 10;
    }
}

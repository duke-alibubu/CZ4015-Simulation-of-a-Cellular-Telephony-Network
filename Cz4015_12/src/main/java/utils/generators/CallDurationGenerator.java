package utils.generators;

import java.util.Random;

public class CallDurationGenerator {
    private static final double MEAN = 99.83194913549542;
    private static final double MIN = 10.003951603252272;

    private Random rand;

    public CallDurationGenerator(){
        rand = new Random();
    }

    public double generateCallDuration(){
        //Use inverse transform to make a exponentially distributed number with mean provided, plus 10
        double u = rand.nextDouble();
        return -Math.log(1 - u) * MEAN + MIN;
    }
}

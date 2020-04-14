package utils.generators;

import java.util.Random;

public class BaseStationGenerator {
    private Random rand;

    public BaseStationGenerator(){
        rand = new Random();
    }
    public int generateBaseStation(){
        return rand.nextInt(20) + 1;  //return a number between 1 and 20
    }
}

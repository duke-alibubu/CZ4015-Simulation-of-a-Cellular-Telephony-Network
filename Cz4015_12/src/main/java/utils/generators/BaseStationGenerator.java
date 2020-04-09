package utils.generators;

import java.util.Random;

public class BaseStationGenerator {
    private static Random rand = new Random();

    public static int generateBaseStation(){
        return rand.nextInt(20) + 1;  //return a number between 1 and 20
    }
}

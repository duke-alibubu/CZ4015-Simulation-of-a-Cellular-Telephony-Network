package utils;

import java.util.Random;

public class InitialPositionGenerator {
    private Random rand;

    //each station shall have its own InitialPositionGenerator to maintain uniform distribution of initial position within itself
    public InitialPositionGenerator(){
        rand = new Random();
    }

    public int generateInitialPosition(){
        return rand.nextInt(2001);  //return a number between 0 and 2000, inclusive
    }
}

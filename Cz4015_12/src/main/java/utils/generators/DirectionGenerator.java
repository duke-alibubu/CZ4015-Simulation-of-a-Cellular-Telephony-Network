package utils.generators;

import utils.enums.Direction;

import java.util.Random;

public class DirectionGenerator {
    //let the RNG to be static since all the directions follow an equal probability
    private Random rand;

    public DirectionGenerator(){
        rand = new Random();
    }
    public Direction generateDirection(){
        boolean randomValue = rand.nextBoolean();
        if (randomValue)
            return Direction.Left;
        else return Direction.Right;
    }
}


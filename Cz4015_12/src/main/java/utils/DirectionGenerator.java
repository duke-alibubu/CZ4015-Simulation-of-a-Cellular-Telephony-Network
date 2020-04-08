package utils;

import utils.Direction;

import java.util.Random;

public class DirectionGenerator {
    private static Random rand = new Random();

    public static Direction generateDirection(){
        boolean randomValue = rand.nextBoolean();
        if (randomValue)
            return Direction.Left;
        else return Direction.Right;
    }
}


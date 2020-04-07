package generator.generators;

import utils.Direction;

public class DirectionGenerator {
    public static Direction generateDirection(){
        double randomValue = Math.random();
        if (randomValue < 0.5)
            return Direction.Left;
        else return Direction.Right;
    }
}


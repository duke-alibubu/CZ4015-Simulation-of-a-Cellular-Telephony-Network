package test;

import utils.Direction;
import utils.DirectionGenerator;
import utils.InitialPositionGenerator;

public class Test {
    public static void main(String[] args){
        int numLeft = 0;
        int numRight = 0;
        int total = 0;
//        for (int i = 0; i < 10000000; i++){
//            if (DirectionGenerator.generateDirection() == Direction.Right)
//                numRight++;
//            else numLeft++;
//        }
//        System.out.println(numRight);
//        System.out.println(numLeft);
        InitialPositionGenerator  initialPositionGenerator = new InitialPositionGenerator();
        for (int i = 0; i < 200000; i++)
            total += initialPositionGenerator.generateInitialPosition();
        System.out.println(total/200000);
    }
}

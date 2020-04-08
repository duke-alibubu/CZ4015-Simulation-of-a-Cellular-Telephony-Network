package test;

import utils.DirectionGenerator;

public class Test {
    public static void main(String[] args){
        for (int i = 0; i < 10; i++)
            System.out.println(DirectionGenerator.generateDirection());
    }
}

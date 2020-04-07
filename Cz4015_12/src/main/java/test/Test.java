package test;

import generator.controller.GeneratorController;

public class Test {
    public static void main(String[] args){
        GeneratorController generatorController = new GeneratorController();
        System.out.println(generatorController.generateCarDirection());
    }
}

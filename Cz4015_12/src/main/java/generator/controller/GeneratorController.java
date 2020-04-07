package generator.controller;

import generator.generators.DirectionGenerator;
import utils.Direction;

public class GeneratorController {
    public Direction generateCarDirection(){
        return DirectionGenerator.generateDirection();
    }
}

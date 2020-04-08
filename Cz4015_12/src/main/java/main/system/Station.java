package main.system;

import utils.generators.InitialPositionGenerator;

public class Station {
    private int numAvailableFreeChannels;
    private int numChannelsReservedForHandover;
    private int maxChannelsReservedForHandover;
    private InitialPositionGenerator initialPositionGenerator;      //each station has its own initial position generator

    public Station(int numAvailableFreeChannels, int numChannelsReservedForHandover) {
        this.numAvailableFreeChannels = numAvailableFreeChannels;
        this.numChannelsReservedForHandover = numChannelsReservedForHandover;
        this.maxChannelsReservedForHandover = numChannelsReservedForHandover;
        initialPositionGenerator = new InitialPositionGenerator();
    }


    public int generateInitialPositionWithinThisStation(){
        return initialPositionGenerator.generateInitialPosition();
    }
}

package main.system;

public class Station {
    private int numAvailableFreeChannels;
    private int numChannelsReservedForHandover;
    private int maxChannelsReservedForHandover;

    public Station(int numAvailableFreeChannels, int numChannelsReservedForHandover) {
        this.numAvailableFreeChannels = numAvailableFreeChannels;
        this.numChannelsReservedForHandover = numChannelsReservedForHandover;
        this.maxChannelsReservedForHandover = numChannelsReservedForHandover;
    }
}

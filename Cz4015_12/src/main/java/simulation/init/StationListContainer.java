package simulation.init;

import simulation.system.Station;
import utils.enums.FCAScheme;

import java.util.ArrayList;
import java.util.List;

public class StationListContainer {
    private final static int NUMBER_OF_STATIONS = 20;
    private static List<Station> stationList;

    private int numAvailableFreeChannels;
    private int numChannelsReservedForHandover;
    public StationListContainer(FCAScheme fcaScheme){
        switch (fcaScheme){
            case No_Channel_Reservation:
                numAvailableFreeChannels = 10;
                numChannelsReservedForHandover = 0;
                break;
            case One_Channel_Reversed_For_Handovers:
                numAvailableFreeChannels = 9;
                numChannelsReservedForHandover = 1;
                break;
            default:
                break;
        }
        stationList = new ArrayList<Station>(NUMBER_OF_STATIONS);
        for (int i = 0; i < NUMBER_OF_STATIONS; i++)
            stationList.add(new Station(numAvailableFreeChannels, numChannelsReservedForHandover));

    }

    public static List<Station> getStationList() {
        return stationList;
    }
}

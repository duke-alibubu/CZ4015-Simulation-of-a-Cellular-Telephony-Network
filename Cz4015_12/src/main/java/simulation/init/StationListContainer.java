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
    private static FCAScheme fcascheme;

    public StationListContainer(FCAScheme fcaScheme){
        fcascheme = fcaScheme;
        switch (fcaScheme){
            case No_Channel_Reservation:
                numAvailableFreeChannels = 10;
                numChannelsReservedForHandover = 0;
                break;
            case One_Channel_Reversed_For_Handovers:
                numAvailableFreeChannels = 9;
                numChannelsReservedForHandover = 1;
                break;
            case Two_Channel_Reversed_For_Handovers:
                numAvailableFreeChannels = 8;
                numChannelsReservedForHandover = 2;
                break;
            case Three_Channel_Reversed_For_Handovers:
                numAvailableFreeChannels = 7;
                numChannelsReservedForHandover = 3;
                break;
            case Four_Channel_Reversed_For_Handovers:
                numAvailableFreeChannels = 6;
                numChannelsReservedForHandover = 4;
                break;
            case Five_Channel_Reversed_For_Handovers:
                numAvailableFreeChannels = 5;
                numChannelsReservedForHandover = 5;
                break;
            case Six_Channel_Reversed_For_Handovers:
                numAvailableFreeChannels = 4;
                numChannelsReservedForHandover = 6;
                break;
            case Seven_Channel_Reversed_For_Handovers:
                numAvailableFreeChannels = 3;
                numChannelsReservedForHandover = 7;
                break;
            case Eight_Channel_Reversed_For_Handovers:
                numAvailableFreeChannels = 2;
                numChannelsReservedForHandover = 8;
                break;
            case Nine_Channel_Reversed_For_Handovers:
                numAvailableFreeChannels = 1;
                numChannelsReservedForHandover = 9;
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
    public static String getFCASchemeName(){
        return fcascheme.name();
    }
}

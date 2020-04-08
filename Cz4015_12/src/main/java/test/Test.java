package test;

import main.init.StationListContainer;
import utils.enums.FCAScheme;
import utils.generators.InitialPositionGenerator;

public class Test {
    public static void main(String[] args){
        int numLeft = 0;
        int numRight = 0;
        int total = 0;


        // TEST DIRECTION
//        for (int i = 0; i < 10000000; i++){
//            if (DirectionGenerator.generateDirection() == Direction.Right)
//                numRight++;
//            else numLeft++;
//        }
//        System.out.println(numRight);
//        System.out.println(numLeft);


        // TEST INITIAL POSITION
//        InitialPositionGenerator  initialPositionGenerator = new InitialPositionGenerator();
//        for (int i = 0; i < 200000; i++)
//            total += initialPositionGenerator.generateInitialPosition();
//        System.out.println(total/200000);

        // TEST GENERATE STATION
//        StationListContainer stationListContainer = new StationListContainer(FCAScheme.One_Channel_Reversed_For_Handovers);
//        System.out.println(StationListContainer.stationList.get(0).numAvailableFreeChannels);
//        System.out.println(StationListContainer.stationList.get(0).maxChannelsReservedForHandover);
//        System.out.println(StationListContainer.stationList.get(0).numChannelsReservedForHandover);
    }
}

package com.darren.factories;

import com.darren.domain.TrainStation;

public class TrainStationFactory {

    public static TrainStation buildTrainStation(String trainStationId, String branchName, String branchManager)
    {
        TrainStation trainStation = new TrainStation.Builder()
                .trainStationId(trainStationId)
                .branchName(branchName)
                .branchManager(branchManager)
                .build();
        return trainStation;
    }
}
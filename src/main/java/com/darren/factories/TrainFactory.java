package com.darren.factories;


import com.darren.domain.Train;

public class TrainFactory {

    public static Train buildTrain(String trainId, String vinNumber, String manufacturerName, String modelName, String yearModel)
    {
        Train train = new Train.Builder()
                .trainId(trainId)
                .vinNumber(vinNumber)
                .manufacturerName(manufacturerName)
                .modelName(modelName)
                .yearModel(yearModel)
                .build();
        return train;
    }
}
package com.darren.factories;

import com.darren.domain.TrainPurchasePrice;

public class TrainPurchasePriceFactory {

    public static TrainPurchasePrice buildTrainPurchasePrice(String trainPurchasePriceId, String trainYearModel, String trainPrice)
    {
        TrainPurchasePrice trainPurchasePrice = new TrainPurchasePrice.Builder()
                .trainPurchasePriceId(trainPurchasePriceId)
                .trainYearModel(trainYearModel)
                .trainPrice(trainPrice)
                .build();
        return trainPurchasePrice;
    }
}

package com.darren.factories;


import com.darren.domain.Asset;

public class AssetFactory {

    public static Asset createAsset(String assetId, String assetNumber, String assetModel, double assetValue) {
        return new Asset.Builder()
                .assetId(assetId)
                .assetNumber(assetNumber)
                .assetModel(assetModel)
                .assetValue(assetValue)
                .build();
    }
}
package com.darren.domain;

public class TrainPurchasePrice {

    private String trainPurchasePriceId;
    private String trainYearModel;
    private String trainPrice;

    public String getTrainPurchasePriceId() {
        return trainPurchasePriceId;
    }

    public void setTrainPurchasePriceId(String trainPurchasePriceId) {
        this.trainPurchasePriceId = trainPurchasePriceId;
    }

    public String getTrainYearModel() {
        return trainYearModel;
    }

    public void setTrainYearModel(String trainYearModel) {
        this.trainYearModel = trainYearModel;
    }

    public String getTrainPrice() {
        return trainPrice;
    }

    public void setTrainPrice(String trainPrice) {
        this.trainPrice = trainPrice;
    }

    private TrainPurchasePrice(){

    }

    public TrainPurchasePrice(Builder builder) {
        this.trainPurchasePriceId = builder.trainPurchasePriceId;
        this.trainYearModel = builder.trainYearModel;
        this.trainPrice = builder.trainPrice;
    }

    public static class Builder{

        private String trainPurchasePriceId;
        private String trainYearModel;
        private String trainPrice;

        public Builder trainPurchasePriceId(String value)
        {
            this.trainPurchasePriceId = value;
            return this;
        }

        public Builder trainYearModel(String value)
        {
            this.trainYearModel = value;
            return this;
        }

        public Builder trainPrice(String value)
        {
            this.trainPrice = value;
            return this;
        }

        public TrainPurchasePrice build(){

            return new TrainPurchasePrice(this);
        }

        public Builder copy(TrainPurchasePrice savedTrainPurchasePrice) {
            this.trainPurchasePriceId = savedTrainPurchasePrice.trainPurchasePriceId;
            this.trainYearModel = savedTrainPurchasePrice.trainYearModel;
            this.trainPrice = savedTrainPurchasePrice.trainPrice;

            return this;
        }
    }
}

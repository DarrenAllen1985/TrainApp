package com.darren.domain;

public class Train {

    private String trainId;
    private String vinNumber;
    private String manufacturerName;
    private String modelName;
    private String yearModel;

    public String getTrainId() {return trainId;}

    public void setTrainId(String trainId) {this.trainId = trainId;}

    public String getVinNumber() { return vinNumber;}

    public void setVinNumber(String vinNumber) {this.vinNumber = vinNumber; }

    public String getManufacturerName() {return manufacturerName;}

    public void setManufacturerName(String manufacturerName) {this.manufacturerName = manufacturerName;}

    public String getModelName() {return modelName;}

    public void setModelName(String modelName) {this.modelName = modelName;}

    public String getYearModel() {return yearModel;}

    public void setYearModel(String yearModel) {this.yearModel = yearModel;}


    private Train(){

    }

    public Train(Builder builder) {
        this.trainId = builder.trainId;
        this.vinNumber = builder.vinNumber;
        this.manufacturerName = builder.manufacturerName;
        this.modelName = builder.modelName;
        this.yearModel = builder.yearModel;
    }

    public static class Builder{

        private String trainId;
        private String vinNumber;
        private String manufacturerName;
        private String modelName;
        private String yearModel;

        public Builder trainId(String value)
        {
            this.trainId = value;
            return this;
        }

        public Builder vinNumber(String value)
        {
            this.vinNumber = value;
            return this;
        }

        public Builder manufacturerName(String value)
        {
            this.manufacturerName = value;
            return this;
        }

        public Builder modelName(String value)
        {
            this.modelName = value;
            return this;
        }

        public Builder yearModel(String value)
        {
            this.yearModel = value;
            return this;
        }

        public Train build(){

            return new Train(this);
        }

        public Builder copy(Train savedTrain) {
            this.trainId = savedTrain.trainId;
            this.vinNumber = savedTrain.vinNumber;
            this.manufacturerName = savedTrain.manufacturerName;
            this.modelName = savedTrain.modelName;
            this.yearModel = savedTrain.yearModel;

            return this;
        }
    }
}

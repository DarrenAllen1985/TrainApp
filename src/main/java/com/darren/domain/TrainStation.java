package com.darren.domain;

public class TrainStation {

    private String trainStationId;
    private String branchName;
    private String branchManager;

    public String getTrainStationId() {
        return trainStationId;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchManager() {
        return branchManager;
    }

    private TrainStation() {
    }

    public TrainStation(Builder builder) {
        this.trainStationId = builder.trainStationId;
        this.branchName = builder.branchName;
        this.branchManager = builder.branchManager;
    }

    public static class Builder{
        private String trainStationId;
        private String branchName;
        private String branchManager;

        public Builder trainStationId(String value){
            this.trainStationId = value;
            return this;
        }

        public Builder branchName(String value){
            this.branchName = value;
            return this;
        }

        public Builder branchManager(String value){
            this.branchManager = value;
            return this;
        }

        public TrainStation build(){

            return new TrainStation(this);
        }

        public Builder copy(TrainStation savedTrainStation) {
            this.trainStationId = savedTrainStation.trainStationId;
            this.branchName = savedTrainStation.branchName;
            this.branchManager = savedTrainStation.branchManager;

            return this;
        }
    }
}

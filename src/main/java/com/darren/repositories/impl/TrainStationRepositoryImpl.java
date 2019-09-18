package com.darren.repositories.impl;

import com.darren.domain.TrainStation;
import com.darren.repositories.TrainStationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("TrainStationRepository")
public class TrainStationRepositoryImpl implements TrainStationRepository {

    private static TrainStationRepositoryImpl repository = null;
    private Set<TrainStation> trainStation;

    private TrainStationRepositoryImpl(){
        this.trainStation = new HashSet<>();
    }

    private TrainStation findTrainStation(String trainStationId) {
        return this.trainStation.stream()
                .filter(trainStation -> trainStation.getTrainStationId().trim().equals(trainStationId))
                .findAny()
                .orElse(null);
    }

    public static TrainStationRepositoryImpl getRepository(){
        if (repository == null) repository = new TrainStationRepositoryImpl();
        return repository;
    }


    public TrainStation create(TrainStation trainStation){
        this.trainStation.add(trainStation);
        return trainStation;
    }

    public TrainStation read(final String trainStationId){
        TrainStation trainStation = findTrainStation(trainStationId);
        return trainStation;
    }

    public void delete(String trainStationId) {
        TrainStation trainStation = findTrainStation(trainStationId);
        if (trainStation != null) this.trainStation.remove(trainStation);
    }

    public TrainStation update(TrainStation trainStation){
        TrainStation toDelete = findTrainStation(trainStation.getTrainStationId());
        if(toDelete != null) {
            this.trainStation.remove(toDelete);
            return create(trainStation);
        }
        return null;
    }


    public Set<TrainStation> getAll(){
        return this.trainStation;
    }
}

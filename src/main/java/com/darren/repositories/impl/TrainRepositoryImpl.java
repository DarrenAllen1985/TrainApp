package com.darren.repositories.impl;


import com.darren.domain.Train;
import com.darren.repositories.TrainRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("TrainRepository")
public class TrainRepositoryImpl implements TrainRepository {

    private static TrainRepositoryImpl repository = null;
    private Set<Train> train;

    private TrainRepositoryImpl(){
        this.train = new HashSet<>();
    }

    private Train findTrain(String trainId) {
        return this.train.stream()
                .filter(train -> train.getTrainId().trim().equals(trainId))
                .findAny()
                .orElse(null);
    }

    public static TrainRepositoryImpl getRepository(){
        if (repository == null) repository = new TrainRepositoryImpl();
        return repository;
    }


    public Train create(Train train){
        this.train.add(train);
        return train;
    }

    public Train read(final String trainId){
        Train train = findTrain(trainId);
        return train;
    }

    public void delete(String trainId) {
        Train train = findTrain(trainId);
        if (train != null) this.train.remove(train);
    }

    public Train update(Train train){
        Train toDelete = findTrain(train.getTrainId());
        if(toDelete != null) {
            this.train.remove(toDelete);
            return create(train);
        }
        return null;
    }


    public Set<Train> getAll(){
        return this.train;
    }
}

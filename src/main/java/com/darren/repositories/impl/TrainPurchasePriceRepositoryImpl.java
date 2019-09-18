package com.darren.repositories.impl;

import com.darren.domain.TrainPurchasePrice;
import com.darren.repositories.TrainPurchasePriceRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("TrainPurchaseRepository")
public class TrainPurchasePriceRepositoryImpl implements TrainPurchasePriceRepository {

    private static TrainPurchasePriceRepositoryImpl repository = null;
    private Set<TrainPurchasePrice> trainPurchasePrice;

    private TrainPurchasePriceRepositoryImpl(){
        this.trainPurchasePrice = new HashSet<>();
    }

    private TrainPurchasePrice findTrainPurchasePrice(String trainPurchasePriceId) {
        return this.trainPurchasePrice.stream()
                .filter(trainPurchasePrice -> trainPurchasePrice.getTrainPurchasePriceId().trim().equals(trainPurchasePriceId))
                .findAny()
                .orElse(null);
    }

    public static TrainPurchasePriceRepositoryImpl getRepository(){
        if (repository == null) repository = new TrainPurchasePriceRepositoryImpl();
        return repository;
    }


    public TrainPurchasePrice create(TrainPurchasePrice trainPurchasePrice){
        this.trainPurchasePrice.add(trainPurchasePrice);
        return trainPurchasePrice;
    }

    public TrainPurchasePrice read(final String trainPurchasePriceId){
        TrainPurchasePrice trainPurchasePrice = findTrainPurchasePrice(trainPurchasePriceId);
        return trainPurchasePrice;
    }

    public void delete(String trainPurchasePriceId) {
        TrainPurchasePrice trainPurchasePrice = findTrainPurchasePrice(trainPurchasePriceId);
        if (trainPurchasePrice != null) this.trainPurchasePrice.remove(trainPurchasePrice);
    }

    public TrainPurchasePrice update(TrainPurchasePrice trainPurchasePrice){
        TrainPurchasePrice toDelete = findTrainPurchasePrice(trainPurchasePrice.getTrainPurchasePriceId());
        if(toDelete != null) {
            this.trainPurchasePrice.remove(toDelete);
            return create(trainPurchasePrice);
        }
        return null;
    }


    public Set<TrainPurchasePrice> getAll(){
        return this.trainPurchasePrice;
    }
}

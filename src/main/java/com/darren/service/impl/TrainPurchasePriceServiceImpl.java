package com.darren.service.impl;

import com.darren.domain.TrainPurchasePrice;
import com.darren.repositories.ContactRepository;
import com.darren.repositories.TrainPurchasePriceRepository;
import com.darren.repositories.impl.TrainPurchasePriceRepositoryImpl;
import com.darren.service.TrainPurchasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("TrainPurchasePriceServiceImpl")
public class TrainPurchasePriceServiceImpl implements TrainPurchasePriceService {
    private final TrainPurchasePriceRepository trainPurchasePriceRepository;

    private TrainPurchasePriceServiceImpl() {
        this.trainPurchasePriceRepository = TrainPurchasePriceRepositoryImpl.getRepository();
    }

    /*public static TrainPurchasePriceServiceImpl getService(){
        if (service == null) service = new TrainPurchasePriceServiceImpl();
        return service;
    }*/

    @Override
    public TrainPurchasePrice create(TrainPurchasePrice trainPurchasePrice) {
        return this.trainPurchasePriceRepository.create(trainPurchasePrice);
    }

    @Override
    public TrainPurchasePrice update(TrainPurchasePrice trainPurchasePrice) {
        return this.trainPurchasePriceRepository.update(trainPurchasePrice);
    }

    @Override
    public void delete(String s) {
        this.trainPurchasePriceRepository.delete(s);
    }

    @Override
    public TrainPurchasePrice read(String s) {
        return this.trainPurchasePriceRepository.read(s);
    }

    @Override
    public Set<TrainPurchasePrice> getAll() {
        return this.trainPurchasePriceRepository.getAll();
    }
}

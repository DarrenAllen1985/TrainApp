package com.darren.service.impl;

import com.darren.domain.TrainPurchasePrice;
import com.darren.repositories.TrainPurchasePriceRepository;
import com.darren.repositories.impl.TrainPurchasePriceRepositoryImpl;
import com.darren.service.TrainPurchasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("TrainPurchasePriceServiceImpl")
public class TrainPurchasePriceServiceImpl implements TrainPurchasePriceService {
    @Autowired

    private static TrainPurchasePriceServiceImpl service = null;
    private TrainPurchasePriceRepository repository;

    private TrainPurchasePriceServiceImpl() {
        this.repository = TrainPurchasePriceRepositoryImpl.getRepository();
    }

    public static TrainPurchasePriceServiceImpl getService(){
        if (service == null) service = new TrainPurchasePriceServiceImpl();
        return service;
    }

    @Override
    public TrainPurchasePrice create(TrainPurchasePrice trainPurchasePrice) {
        return this.repository.create(trainPurchasePrice);
    }

    @Override
    public TrainPurchasePrice update(TrainPurchasePrice trainPurchasePrice) {
        return this.repository.update(trainPurchasePrice);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public TrainPurchasePrice read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<TrainPurchasePrice> getAll() {
        return this.repository.getAll();
    }
}

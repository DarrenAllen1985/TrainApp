package com.darren.service.impl;

import com.darren.domain.TrainStation;
import com.darren.repositories.TrainStationRepository;
import com.darren.repositories.impl.TrainStationRepositoryImpl;
import com.darren.service.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("TrainStationServiceImpl")
public class TrainStationServiceImpl implements TrainStationService {
    @Autowired

    private static TrainStationServiceImpl service = null;
    private TrainStationRepository repository;

    private TrainStationServiceImpl() {
        this.repository = TrainStationRepositoryImpl.getRepository();
    }

    public static TrainStationServiceImpl getService(){
        if (service == null) service = new TrainStationServiceImpl();
        return service;
    }

    @Override
    public TrainStation create(TrainStation trainStation) {
        return this.repository.create(trainStation);
    }

    @Override
    public TrainStation update(TrainStation trainStation) {
        return this.repository.update(trainStation);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public TrainStation read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<TrainStation> getAll() {
        return this.repository.getAll();
    }
}

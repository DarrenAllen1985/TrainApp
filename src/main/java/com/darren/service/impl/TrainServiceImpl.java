package com.darren.service.impl;


import com.darren.domain.Train;
import com.darren.repositories.TrainRepository;
import com.darren.repositories.impl.TrainRepositoryImpl;
import com.darren.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("TrainServiceImpl")
public class TrainServiceImpl implements TrainService {
    @Autowired

    private static TrainServiceImpl service = null;
    private TrainRepository repository;

    private TrainServiceImpl() {
        this.repository = TrainRepositoryImpl.getRepository();
    }

    public static TrainServiceImpl getService(){
        if (service == null) service = new TrainServiceImpl();
        return service;
    }

    @Override
    public Train create(Train train) {
        return this.repository.create(train);
    }

    @Override
    public Train update(Train train) {
        return this.repository.update(train);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Train read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Train> getAll() {
        return this.repository.getAll();
    }
}

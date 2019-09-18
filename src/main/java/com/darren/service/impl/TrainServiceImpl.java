package com.darren.service.impl;


import com.darren.domain.Train;
import com.darren.domain.Website;
import com.darren.repositories.ContactRepository;
import com.darren.repositories.TrainRepository;
import com.darren.repositories.impl.TrainRepositoryImpl;
import com.darren.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("TrainServiceImpl")
public class TrainServiceImpl implements TrainService {
    private final TrainRepositoryImpl trainRepository;

    private TrainServiceImpl() {
        this.trainRepository = TrainRepositoryImpl.getRepository();
    }

   /* public static TrainServiceImpl getService(){
        if (service == null) service = new TrainServiceImpl();
        return service;
    }*/

    @Override
    public Train create(Train train) {
        return this.trainRepository.create(train);
    }

    @Override
    public Train update(Train train) {
        return this.trainRepository.update(train);
    }

    @Override
    public void delete(String s) {
        this.trainRepository.delete(s);
    }

    @Override
    public Train read(String s) {
        return this.trainRepository.read(s);
    }

    @Override
    public Set<Train> getAll() {
        return this.trainRepository.getAll();
    }
}

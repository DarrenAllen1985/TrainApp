package com.darren.service.impl;

import com.darren.domain.Profit;
import com.darren.repositories.ProfitRepository;
import com.darren.repositories.impl.ProfitRepositoryImpl;
import com.darren.service.ProfitService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ProfitServiceImpl")
public class ProfitServiceImpl implements ProfitService {
    @Autowired

    private static ProfitServiceImpl service = null;
    private ProfitRepository repository;

    private ProfitServiceImpl() {
        this.repository = ProfitRepositoryImpl.getRepository();
    }

    public static ProfitServiceImpl getService(){
        if (service == null) service = new ProfitServiceImpl();
        return service;
    }

    @Override
    public Profit create(Profit profit) {
        return this.repository.create(profit);
    }

    @Override
    public Profit update(Profit profit) {
        return this.repository.update(profit);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Profit read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Profit> getAll() {
        return this.repository.getAll();
    }
}

package com.darren.service.impl;

import com.darren.domain.Revenue;
import com.darren.domain.Website;
import com.darren.repositories.RevenueRepository;
import com.darren.repositories.impl.RevenueRepositoryImpl;
import com.darren.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("RevenueServiceImpl")
public class RevenueServiceImpl implements RevenueService {
    private final RevenueRepository revenueRepository;

    private RevenueServiceImpl() {
        this.revenueRepository = RevenueRepositoryImpl.getRepository();
    }

   /* public static RevenueServiceImpl getService(){
        if (service == null) service = new RevenueServiceImpl();
        return service;
    }*/

    @Override
    public Revenue create(Revenue revenue) {
        return this.revenueRepository.create(revenue);
    }

    @Override
    public Revenue update(Revenue revenue) {
        return this.revenueRepository.update(revenue);
    }

    @Override
    public void delete(String s) {
        this.revenueRepository.delete(s);
    }

    @Override
    public Revenue read(String s) {
        return this.revenueRepository.read(s);
    }

    @Override
    public Set<Revenue> getAll() {
        return this.revenueRepository.getAll();
    }
}

package com.darren.service.impl;

import com.darren.domain.Region;
import com.darren.domain.Website;
import com.darren.repositories.RegionRepository;
import com.darren.repositories.impl.RegionRepositoryImpl;
import com.darren.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("RegionServiceImpl")
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;

    private RegionServiceImpl() {
        this.regionRepository = RegionRepositoryImpl.getRepository();
    }

    /*public static RegionServiceImpl getService(){
        if (service == null) service = new RegionServiceImpl();
        return service;
    }*/

    @Override
    public Region create(Region region) {
        return this.regionRepository.create(region);
    }

    @Override
    public Region update(Region region) {
        return this.regionRepository.update(region);
    }

    @Override
    public void delete(String s) {
        this.regionRepository.delete(s);
    }

    @Override
    public Region read(String s) {
        return this.regionRepository.read(s);
    }

    @Override
    public Set<Region> getAll() {
        return this.regionRepository.getAll();
    }
}

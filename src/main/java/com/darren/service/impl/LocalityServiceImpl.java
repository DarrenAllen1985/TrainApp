package com.darren.service.impl;


import com.darren.domain.Locality;
import com.darren.repositories.LocalityRepository;
import com.darren.repositories.impl.LocalityRepositoryImpl;
import com.darren.service.LocalityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("LocalityServiceImpl")
public class LocalityServiceImpl implements LocalityService {
    private final LocalityRepository localityRepository;

    private LocalityServiceImpl() {
        this.localityRepository = LocalityRepositoryImpl.getLocalityRepository();
    }

    @Override
    public Locality create(Locality locality) {
        return this.localityRepository.create(locality);
    }

    @Override
    public Locality read(String localityId) {
        return this.localityRepository.read(localityId);
    }

    @Override
    public Locality update(Locality locality) {
        return this.localityRepository.update(locality);
    }

    @Override
    public void delete(String localityId) {
        this.localityRepository.delete(localityId);
    }

    @Override
    public Set<Locality> getAll() {
        return this.localityRepository.getAll();
    }
}
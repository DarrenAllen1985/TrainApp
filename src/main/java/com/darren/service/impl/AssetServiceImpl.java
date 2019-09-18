package com.darren.service.impl;


import com.darren.domain.Asset;
import com.darren.repositories.AssetRepository;
import com.darren.repositories.impl.AssetRepositoryImpl;
import com.darren.service.AssetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AssetServiceImpl")
public class AssetServiceImpl implements AssetService {
    private final AssetRepository assetRepository;

    private AssetServiceImpl() {
        this.assetRepository = AssetRepositoryImpl.getAssetRepository();
    }

    @Override
    public Set<Asset> getAll() {
        return this.assetRepository.getAll();
    }

    @Override
    public Asset create(Asset asset) {
        return this.assetRepository.create(asset);
    }

    @Override
    public Asset read(String assetId) {
        return this.assetRepository.read(assetId);
    }

    @Override
    public Asset update(Asset asset) {
        return this.assetRepository.update(asset);
    }

    @Override
    public void delete(String assetId) {
        this.assetRepository.delete(assetId);
    }
}
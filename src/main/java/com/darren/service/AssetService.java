package com.darren.service;


import com.darren.domain.Asset;

import java.util.Set;

public interface AssetService extends CrudService<Asset, String> {
    Set<Asset> getAll();
}
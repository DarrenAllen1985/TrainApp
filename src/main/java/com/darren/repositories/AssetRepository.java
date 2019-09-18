package com.darren.repositories;


import com.darren.domain.Asset;

import java.util.Set;

public interface AssetRepository extends CrudRepository<Asset, String> {
    Set<Asset> getAll();
}

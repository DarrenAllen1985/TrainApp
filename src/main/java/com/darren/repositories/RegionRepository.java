package com.darren.repositories;

import com.darren.domain.Region;

import java.util.Set;


public interface RegionRepository extends CrudRepository<Region, String> {

    Set<Region> getAll();
}

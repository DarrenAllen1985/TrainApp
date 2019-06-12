package com.darren.service;

import com.darren.domain.Region;

import java.util.Set;

public interface RegionService extends CrudService<Region, String>{
    Set<Region> getAll();
}

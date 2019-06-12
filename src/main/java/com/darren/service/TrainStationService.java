package com.darren.service;

import com.darren.domain.TrainStation;

import java.util.Set;

public interface TrainStationService extends CrudService<TrainStation, String>{
    Set<TrainStation> getAll();
}

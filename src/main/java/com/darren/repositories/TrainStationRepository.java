package com.darren.repositories;

import com.darren.domain.TrainStation;

import java.util.Set;


public interface TrainStationRepository extends CrudRepository<TrainStation, String> {

    Set<TrainStation> getAll();
    //public List<TrainStation> findByAge(int age);
    //public List<TrainStation> findById(String id);

}

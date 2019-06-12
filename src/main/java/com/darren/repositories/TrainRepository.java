package com.darren.repositories;


import com.darren.domain.Train;

import java.util.Set;


public interface TrainRepository extends CrudRepository<Train, String> {

    Set<Train> getAll();
    //public List<Car> findByAge(int age);
    //public List<Car> findById(String id);

}

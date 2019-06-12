package com.darren.service;


import com.darren.domain.Train;

import java.util.Set;

public interface TrainService extends CrudService<Train, String>{
    Set<Train> getAll();
}

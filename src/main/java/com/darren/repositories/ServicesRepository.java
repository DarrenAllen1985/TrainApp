package com.darren.repositories;


import com.darren.domain.Services;

import java.util.Set;

public interface ServicesRepository extends CrudRepository<Services, String> {
    Set<Services> getAll();
}
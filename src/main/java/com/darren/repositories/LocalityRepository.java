package com.darren.repositories;


import com.darren.domain.Locality;

import java.util.Set;

public interface LocalityRepository extends CrudRepository<Locality, String> {
    Set<Locality> getAll();
}
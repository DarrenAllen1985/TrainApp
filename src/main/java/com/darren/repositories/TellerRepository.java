package com.darren.repositories;

import com.darren.domain.Teller;

import java.util.Set;


public interface TellerRepository extends CrudRepository<Teller, String> {

    Set<Teller> getAll();
}

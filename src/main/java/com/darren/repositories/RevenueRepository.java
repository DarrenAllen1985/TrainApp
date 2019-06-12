package com.darren.repositories;

import com.darren.domain.Revenue;

import java.util.Set;


public interface RevenueRepository extends CrudRepository<Revenue, String> {

    Set<Revenue> getAll();
}

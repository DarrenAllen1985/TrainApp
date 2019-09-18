package com.darren.repositories;

import com.darren.domain.Website;

import java.util.Set;


public interface WebsiteRepository extends CrudRepository<Website, String> {

    Set<Website> getAll();
}

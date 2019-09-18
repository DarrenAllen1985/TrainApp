package com.darren.service;


import com.darren.domain.Locality;

import java.util.Set;

public interface LocalityService extends CrudService<Locality, String> {
    Set<Locality> getAll();
}
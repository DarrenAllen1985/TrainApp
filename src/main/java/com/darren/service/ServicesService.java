package com.darren.service;


import com.darren.domain.Services;

import java.util.Set;

public interface ServicesService extends CrudService<Services, String> {
    Set<Services> getAll();
}
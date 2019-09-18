package com.darren.service;

import com.darren.domain.Region;
import com.darren.domain.Website;

import java.util.Set;

public interface WebsiteService extends CrudService<Website, String>{
    Set<Website> getAll();
}

package com.darren.service;

import com.darren.domain.Revenue;

import java.util.Set;

public interface RevenueService extends CrudService<Revenue, String>{
    Set<Revenue> getAll();
}

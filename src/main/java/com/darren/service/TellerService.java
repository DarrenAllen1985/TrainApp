package com.darren.service;

import com.darren.domain.Teller;

import java.util.Set;

public interface TellerService extends CrudService<Teller, String>{
    Set<Teller> getAll();
}

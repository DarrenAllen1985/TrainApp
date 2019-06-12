package com.darren.service;


import com.darren.domain.Profit;

import java.util.Set;

public interface ProfitService extends CrudService<Profit, String>{
    Set<Profit> getAll();
}

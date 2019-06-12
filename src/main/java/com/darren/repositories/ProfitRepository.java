package com.darren.repositories;


import com.darren.domain.Profit;
import java.util.Set;


public interface ProfitRepository extends CrudRepository<Profit, String> {

    Set<Profit> getAll();
}

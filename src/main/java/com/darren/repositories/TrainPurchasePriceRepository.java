package com.darren.repositories;

import com.darren.domain.TrainPurchasePrice;

import java.util.Set;


public interface TrainPurchasePriceRepository extends CrudRepository<TrainPurchasePrice, String> {

    Set<TrainPurchasePrice> getAll();
}

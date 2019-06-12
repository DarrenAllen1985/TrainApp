package com.darren.service;

import com.darren.domain.TrainPurchasePrice;

import java.util.Set;

public interface TrainPurchasePriceService extends CrudService<TrainPurchasePrice, String>{
    Set<TrainPurchasePrice> getAll();
}

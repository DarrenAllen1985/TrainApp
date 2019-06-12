package com.darren.controller;

import com.darren.domain.TrainPurchasePrice;
import com.darren.service.TrainPurchasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/trainPurchasePrice")
public class TrainPurchasePriceController {
    @Autowired
    @Qualifier("TrainPurchasePriceServiceImpl")
    private TrainPurchasePriceService service;

    @PostMapping("/create")
    @ResponseBody
    public TrainPurchasePrice create(TrainPurchasePrice trainPurchasePrice) {
        return service.create(trainPurchasePrice);
    }

    @PostMapping("/update")
    @ResponseBody
    public TrainPurchasePrice update(TrainPurchasePrice trainPurchasePrice) {
        return service.update(trainPurchasePrice);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public TrainPurchasePrice read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<TrainPurchasePrice> getAll() {
        return service.getAll();
    }

}

package com.darren.controller;

import com.darren.domain.TrainStation;
import com.darren.service.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/trainStation")
public class TrainStationController {
    @Autowired
    @Qualifier("TrainStationServiceImpl")
    private TrainStationService service;

    @PostMapping("/create")
    @ResponseBody
    public TrainStation create(TrainStation trainStation) {
        return service.create(trainStation);
    }

    @PostMapping("/update")
    @ResponseBody
    public TrainStation update(TrainStation trainStation) {
        return service.update(trainStation);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public TrainStation read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<TrainStation> getAll() {
        return service.getAll();
    }

}

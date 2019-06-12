package com.darren.controller;


import com.darren.domain.Train;
import com.darren.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/train")
public class TrainController {
    @Autowired
    @Qualifier("TrainServiceImpl")
    private TrainService service;

    @PostMapping("/create")
    @ResponseBody
    public Train create(Train train) {
        return service.create(train);
    }

    @PostMapping("/update")
    @ResponseBody
    public Train update(Train train) {
        return service.update(train);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Train read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Train> getAll() {
        return service.getAll();
    }

}

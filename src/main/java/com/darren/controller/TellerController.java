package com.darren.controller;

import com.darren.domain.Teller;
import com.darren.service.TellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/teller")
public class TellerController {
    @Autowired
    @Qualifier("TellerServiceImpl")
    private TellerService service;

    @PostMapping("/create")
    @ResponseBody
    public Teller create(Teller teller) {
        return service.create(teller);
    }

    @PostMapping("/update")
    @ResponseBody
    public Teller update(Teller teller) {
        return service.update(teller);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Teller read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Teller> getAll() {
        return service.getAll();
    }

}

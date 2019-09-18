package com.darren.controller;

import com.darren.domain.Website;
import com.darren.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/website")
public class WebsiteController {
    @Autowired
    @Qualifier("WebsiteServiceImpl")
    private WebsiteService service;

    @PostMapping("/create")
    @ResponseBody
    public Website create(Website website) {
        return service.create(website);
    }

    @PostMapping("/update")
    @ResponseBody
    public Website update(Website website) {
        return service.update(website);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Website read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Website> getAll() {
        return service.getAll();
    }

}

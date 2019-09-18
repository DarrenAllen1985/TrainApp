package com.darren.controller;


import com.darren.domain.TicketDetails;
import com.darren.service.TicketDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/ticketdetails")
public class TicketDetailsController {
    @Autowired
    @Qualifier("TicketDetailsServiceImpl")
    private TicketDetailsService service;

    @PostMapping("/create")
    @ResponseBody
    public TicketDetails create(TicketDetails ticketdetails) {
        return service.create(ticketdetails);
    }

    @PostMapping("/update")
    @ResponseBody
    public TicketDetails update(TicketDetails ticketdetails) {
        return service.update(ticketdetails);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public TicketDetails read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<TicketDetails> getAll() {
        return service.getAll();
    }

}

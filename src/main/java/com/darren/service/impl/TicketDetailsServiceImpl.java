package com.darren.service.impl;
import com.darren.domain.TicketDetails;
import com.darren.repositories.ContactRepository;
import com.darren.repositories.TicketDetailsRepository;
import com.darren.repositories.impl.TicketDetailsRepositoryImpl;
import com.darren.service.TicketDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("TicketDetailsServiceImpl")
public class TicketDetailsServiceImpl implements TicketDetailsService {
    private final TicketDetailsRepository ticketDetailsRepository;

    private TicketDetailsServiceImpl() {
        this.ticketDetailsRepository = TicketDetailsRepositoryImpl.getRepository();
    }

    /*public static TicketDetailsServiceImpl getService(){
        if (service == null) service = new TicketDetailsServiceImpl();
        return service;
    }*/

    @Override
    public TicketDetails create(TicketDetails ticketDetails) {
        return this.ticketDetailsRepository.create(ticketDetails);
    }

    @Override
    public TicketDetails update(TicketDetails ticketDetails) {
        return this.ticketDetailsRepository.update(ticketDetails);
    }

    @Override
    public void delete(String s) {
        this.ticketDetailsRepository.delete(s);
    }

    @Override
    public TicketDetails read(String s) {
        return this.ticketDetailsRepository.read(s);
    }

    @Override
    public Set<TicketDetails> getAll() {
        return this.ticketDetailsRepository.getAll();
    }
}

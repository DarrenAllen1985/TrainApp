package com.darren.service;



import com.darren.domain.TicketDetails;

import java.util.Set;

public interface TicketDetailsService extends CrudService<TicketDetails, String>{
    Set<TicketDetails> getAll();
}
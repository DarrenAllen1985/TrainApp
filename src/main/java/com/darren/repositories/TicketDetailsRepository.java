package com.darren.repositories;

;

import com.darren.domain.TicketDetails;

import java.util.Set;

public interface TicketDetailsRepository extends CrudRepository<TicketDetails, String> {
    Set<TicketDetails> getAll();

}

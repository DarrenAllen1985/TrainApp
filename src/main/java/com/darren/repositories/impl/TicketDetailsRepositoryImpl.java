package com.darren.repositories.impl;



import com.darren.domain.TicketDetails;
import com.darren.repositories.TicketDetailsRepository;
import org.springframework.stereotype.Repository;


import java.util.HashSet;
import java.util.Set;
@Repository("TicketDetailsRepository")
public class TicketDetailsRepositoryImpl implements TicketDetailsRepository {
    private static TicketDetailsRepositoryImpl repository = null;
    private Set<TicketDetails> ticketdetails;

    private TicketDetailsRepositoryImpl(){
        this.ticketdetails = new HashSet<>();
    }

    private TicketDetails findTicketdeials(String ticketdetailsId) {
        return this.ticketdetails.stream()
                .filter(ticketdetails -> ticketdetails.getTrianNo().trim().equals(ticketdetailsId))
                .findAny()
                .orElse(null);
    }

    public static TicketDetailsRepositoryImpl getRepository(){
        if (repository == null) repository = new TicketDetailsRepositoryImpl();
        return repository;
    }


    @Override
    public Set<TicketDetails> getAll() {
        return null;
    }

    public TicketDetails create(TicketDetails ticketdetails){
        this.ticketdetails.add(ticketdetails);
        return ticketdetails;
    }

    public TicketDetails read(final String ticketdetailsId){
        TicketDetails ticketdetails = findTicketdeials(ticketdetailsId);
        return ticketdetails;
    }

    public void delete(String ticketdetailsId) {
        TicketDetails ticketdetails = findTicketdeials(ticketdetailsId);
        if (ticketdetails != null) this.ticketdetails.remove(ticketdetails);
    }

    public TicketDetails update(TicketDetails ticketdetails){
        TicketDetails toDelete = findTicketdeials(ticketdetails.getTrianNo());
        if(toDelete != null) {
            this.ticketdetails.remove(toDelete);
            return create(ticketdetails);
        }
        return null;
    }

}

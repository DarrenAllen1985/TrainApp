package com.darren.factories;


import com.darren.domain.TicketDetails;

public class TicketDetailsFactory {
    public static TicketDetails getTicketDetails(String DDate, String Destination, String depature, String TrianNo ){
        return new TicketDetails.Builder()
                .DDate(DDate)
                .Destination(Destination)
                .depature(depature)
                .TrianNo(TrianNo)
                .build();
    }
}

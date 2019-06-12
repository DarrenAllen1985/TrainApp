package com.darren.factories;


import com.darren.domain.Teller;

public class TellerFactory {

    public static Teller buildTeller(String tellerId, String tellerName, String tellerPassword)
    {
        Teller teller = new Teller.Builder()
                .tellerId(tellerId)
                .tellerName(tellerName)
                .tellerPassword(tellerPassword)
                .build();
        return teller;
    }
}

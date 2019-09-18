package com.darren.repositories.impl;


import com.darren.domain.Teller;
import com.darren.repositories.TellerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("TellerRepository")
public class TellerRepositoryImpl implements TellerRepository {

    private static TellerRepositoryImpl repository = null;
    private Set<Teller> teller;

    private TellerRepositoryImpl(){
        this.teller = new HashSet<>();
    }

    private Teller findTeller(String tellerId) {
        return this.teller.stream()
                .filter(teller -> teller.getTellerId().trim().equals(tellerId))
                .findAny()
                .orElse(null);
    }

    public static TellerRepositoryImpl getRepository(){
        if (repository == null) repository = new TellerRepositoryImpl();
        return repository;
    }


    public Teller create(Teller teller){
        this.teller.add(teller);
        return teller;
    }

    public Teller read(final String tellerId){
        Teller teller = findTeller(tellerId);
        return teller;
    }

    public void delete(String tellerId) {
        Teller teller = findTeller(tellerId);
        if (teller != null) this.teller.remove(teller);
    }

    public Teller update(Teller teller){
        Teller toDelete = findTeller(teller.getTellerId());
        if(toDelete != null) {
            this.teller.remove(toDelete);
            return create(teller);
        }
        return null;
    }


    public Set<Teller> getAll(){
        return this.teller;
    }
}

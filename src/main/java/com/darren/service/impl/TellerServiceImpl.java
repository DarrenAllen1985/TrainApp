package com.darren.service.impl;

import com.darren.domain.Teller;
import com.darren.domain.Website;
import com.darren.repositories.TellerRepository;
import com.darren.repositories.impl.TellerRepositoryImpl;
import com.darren.service.TellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("TellerServiceImpl")
public class TellerServiceImpl implements TellerService {
    @Autowired
    private TellerRepository repository;

    private static TellerServiceImpl service = null;

    private TellerServiceImpl() {
        this.repository = TellerRepositoryImpl.getRepository();
    }

    public static TellerServiceImpl getService(){
        if (service == null) service = new TellerServiceImpl();
        return service;
    }

    @Override
    public Teller create(Teller teller) {
        return this.repository.create(teller);
    }

    @Override
    public Teller update(Teller teller) {
        return this.repository.update(teller);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Teller read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Teller> getAll() {
        return this.repository.getAll();
    }
}

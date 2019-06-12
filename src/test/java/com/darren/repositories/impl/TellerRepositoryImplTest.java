package com.darren.repositories.impl;

import com.darren.domain.Teller;
import com.darren.factories.TellerFactory;
import com.darren.repositories.TellerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TellerRepositoryImplTest {

    private TellerRepository repository;
    private Teller teller;

    private Teller getSavedTeller() {
        Set<Teller> savedTellers = this.repository.getAll();
        return savedTellers.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TellerRepositoryImpl.getRepository();
        this.teller = TellerFactory.buildTeller("123", "TellerUser", "Password123");
    }

    @Test
    public void a_create() {
        Teller created = this.repository.create(this.teller);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.teller);
    }

    @Test
    public void b_read() {
       Teller savedTeller = getSavedTeller();
        System.out.println("In read, tellerId = "+ savedTeller.getTellerId());
        Teller read = this.repository.read(savedTeller.getTellerId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedTeller, read);
    }

    @Test
    public void e_delete() {
        Teller savedTeller = getSavedTeller();
        this.repository.delete(savedTeller.getTellerId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Teller Name";
        Teller teller = new Teller.Builder().copy(getSavedTeller()).tellerName(newname).build();
        System.out.println("In update, about_to_updated = " + teller);
        Teller updated = this.repository.update(teller);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Teller> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}

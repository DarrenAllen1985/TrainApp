package com.darren.service.impl;

import com.darren.domain.Teller;
import com.darren.factories.TellerFactory;
import com.darren.repositories.impl.TellerRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TellerServiceImplTest {

    private TellerRepositoryImpl repository;
    private Teller teller;

    private Teller getSaved(){
        return this.repository.getAll().iterator().next();
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.teller);
    }

    @Test
    public void c_update() {
        String newTellerName = "Application Development Theory 3";
        Teller updated = new Teller.Builder().copy(getSaved()).tellerId(newTellerName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newTellerName, updated.getTellerId());
    }

    @Test
    public void e_delete() {
        Teller saved = getSaved();
        this.repository.delete(saved.getTellerId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Teller saved = getSaved();
        Teller read = this.repository.read(saved.getTellerId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Teller> tellers = this.repository.getAll();
        System.out.println("In getall, all = " + tellers);
    }
}

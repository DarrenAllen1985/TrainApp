package com.darren.service.impl;

import com.darren.domain.Train;
import com.darren.factories.TrainFactory;
import com.darren.repositories.impl.TrainRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerServiceImplTest {

    private TrainRepositoryImpl repository;
    private Train train;

    private Train getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TrainRepositoryImpl.getRepository();
        this.train = TrainFactory.buildTrain("123456", "13443975", "MAN", "G666", "2016");
    }

    @Test
    public void a_create() {
        Train created = this.repository.create(this.train);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.train);
    }

    @Test
    public void c_update() {
        String newTrainName = "Application Development Theory 3";
        Train updated = new Train.Builder().copy(getSaved()).trainId(newTrainName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newTrainName, updated.getTrainId());
    }

    @Test
    public void e_delete() {
        Train saved = getSaved();
        this.repository.delete(saved.getTrainId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Train saved = getSaved();
        Train read = this.repository.read(saved.getTrainId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Train> trains = this.repository.getAll();
        System.out.println("In getall, all = " + trains);
    }
}

package com.darren.repositories.impl;


import com.darren.domain.Train;
import com.darren.factories.TrainFactory;
import com.darren.repositories.TrainRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrainRepositoryImplTest {

    private TrainRepository repository;
    private Train train;

    private Train getSavedTrain() {
        Set<Train> savedTrains = this.repository.getAll();
        return savedTrains.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TrainRepositoryImpl.getRepository();
        this.train = TrainFactory.buildTrain("123456", "13443975", "Man", "G666", "2016");
    }

    @Test
    public void a_create() {
        Train created = this.repository.create(this.train);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.train);
    }

    @Test
    public void b_read() {
       Train savedTrain = getSavedTrain();
        System.out.println("In read, trainId = "+ savedTrain.getTrainId());
        Train read = this.repository.read(savedTrain.getTrainId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedTrain, read);
    }

    @Test
    public void e_delete() {
        Train savedTrain = getSavedTrain();
        this.repository.delete(savedTrain.getTrainId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Train Name";
        Train train = new Train.Builder().copy(getSavedTrain()).modelName(newname).build();
        System.out.println("In update, about_to_updated = " + train);
        Train updated = this.repository.update(train);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getModelName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Train> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}

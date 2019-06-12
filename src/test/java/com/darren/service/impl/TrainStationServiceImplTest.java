package com.darren.service.impl;

import com.darren.domain.TrainStation;
import com.darren.factories.TrainStationFactory;
import com.darren.repositories.impl.TrainStationRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrainStationServiceImplTest {

    private TrainStationRepositoryImpl repository;
    private TrainStation trainStation;

    private TrainStation getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TrainStationRepositoryImpl.getRepository();
        this.trainStation = TrainStationFactory.buildTrainStation("123", "TestBranch", "TestManager");
    }

    @Test
    public void a_create() {
        TrainStation created = this.repository.create(this.trainStation);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.trainStation);
    }

    @Test
    public void c_update() {
        String newTrainStationName = "Application Development Theory 3";
        TrainStation updated = new TrainStation.Builder().copy(getSaved()).trainStationId(newTrainStationName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newTrainStationName, updated.getTrainStationId());
    }

    @Test
    public void e_delete() {
        TrainStation saved = getSaved();
        this.repository.delete(saved.getTrainStationId());
        d_getAll();
    }

    @Test
    public void b_read() {
        TrainStation saved = getSaved();
        TrainStation read = this.repository.read(saved.getTrainStationId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<TrainStation> trainStations = this.repository.getAll();
        System.out.println("In getall, all = " + trainStations);
    }
}

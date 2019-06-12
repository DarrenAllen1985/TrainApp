package com.darren.repositories.impl;

import com.darren.domain.TrainStation;
import com.darren.factories.TrainStationFactory;
import com.darren.repositories.TrainStationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrainStationRepositoryImplTest {

    private TrainStationRepository repository;
    private TrainStation trainStation;

    private TrainStation getSavedTrainStation() {
        Set<TrainStation> savedTrainStations = this.repository.getAll();
        return savedTrainStations.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.trainStation);
    }

    @Test
    public void b_read() {
       TrainStation savedTrainStation = getSavedTrainStation();
        System.out.println("In read, trainStationId = "+ savedTrainStation.getTrainStationId());
        TrainStation read = this.repository.read(savedTrainStation.getTrainStationId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedTrainStation, read);
    }

    @Test
    public void e_delete() {
        TrainStation savedTrainStation = getSavedTrainStation();
        this.repository.delete(savedTrainStation.getTrainStationId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test TrainStation Name";
        TrainStation trainStation = new TrainStation.Builder().copy(getSavedTrainStation()).branchName(newname).build();
        System.out.println("In update, about_to_updated = " + trainStation);
        TrainStation updated = this.repository.update(trainStation);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getBranchName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<TrainStation> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}

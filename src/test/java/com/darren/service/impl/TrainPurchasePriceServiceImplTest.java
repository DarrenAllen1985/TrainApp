package com.darren.service.impl;

import com.darren.domain.TrainPurchasePrice;
import com.darren.factories.TrainPurchasePriceFactory;
import com.darren.repositories.impl.TrainPurchasePriceRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrainPurchasePriceServiceImplTest {

    private TrainPurchasePriceRepositoryImpl repository;
    private TrainPurchasePrice trainPurchasePrice;

    private TrainPurchasePrice getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TrainPurchasePriceRepositoryImpl.getRepository();
        this.trainPurchasePrice = TrainPurchasePriceFactory.buildTrainPurchasePrice("452", "2016", "160000");
    }

    @Test
    public void a_create() {
        TrainPurchasePrice created = this.repository.create(this.trainPurchasePrice);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.trainPurchasePrice);
    }

    @Test
    public void c_update() {
        String newTrainPurchasePriceName = "Application Development Theory 3";
        TrainPurchasePrice updated = new TrainPurchasePrice.Builder().copy(getSaved()).trainPurchasePriceId(newTrainPurchasePriceName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newTrainPurchasePriceName, updated.getTrainPurchasePriceId());
    }

    @Test
    public void e_delete() {
        TrainPurchasePrice saved = getSaved();
        this.repository.delete(saved.getTrainPurchasePriceId());
        d_getAll();
    }

    @Test
    public void b_read() {
        TrainPurchasePrice saved = getSaved();
        TrainPurchasePrice read = this.repository.read(saved.getTrainPurchasePriceId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<TrainPurchasePrice> trainPurchasePrices = this.repository.getAll();
        System.out.println("In getall, all = " + trainPurchasePrices);
    }
}

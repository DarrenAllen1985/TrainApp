package com.darren.repositories.impl;

import com.darren.domain.TrainPurchasePrice;
import com.darren.factories.TrainPurchasePriceFactory;
import com.darren.repositories.TrainPurchasePriceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrainPurchasePriceRepositoryImplTest {

    private TrainPurchasePriceRepository repository;
    private TrainPurchasePrice trainPurchasePrice;

    private TrainPurchasePrice getSavedTrainPurchasePrice() {
        Set<TrainPurchasePrice> savedTrainPurchasePrices = this.repository.getAll();
        return savedTrainPurchasePrices.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, this.trainPurchasePrice);
    }

    @Test
    public void b_read() {
       TrainPurchasePrice savedTrainPurchasePrice = getSavedTrainPurchasePrice();
        System.out.println("In read, trainPurchasePriceId = "+ savedTrainPurchasePrice.getTrainPurchasePriceId());
        TrainPurchasePrice read = this.repository.read(savedTrainPurchasePrice.getTrainPurchasePriceId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedTrainPurchasePrice, read);
    }

    @Test
    public void e_delete() {
        TrainPurchasePrice savedTrainPurchasePrice = getSavedTrainPurchasePrice();
        this.repository.delete(savedTrainPurchasePrice.getTrainPurchasePriceId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test TrainPurchasePrice Name";
        TrainPurchasePrice trainPurchasePrice = new TrainPurchasePrice.Builder().copy(getSavedTrainPurchasePrice()).trainPrice(newname).build();
        System.out.println("In update, about_to_updated = " + trainPurchasePrice);
        TrainPurchasePrice updated = this.repository.update(trainPurchasePrice);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getTrainPrice());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<TrainPurchasePrice> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}

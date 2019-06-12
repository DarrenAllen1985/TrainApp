package com.darren.factories;


import com.darren.domain.TrainPurchasePrice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainPurchasePriceFactoryTest {

    public void testBuildTrainPurchasePrice(){

    }

    private String TrainPurchasePriceTest;

    @Before
    public void setUp() throws Exception {
        this.TrainPurchasePriceTest = "TrainPurchasePriceTest";
    }

    @Test
    public void buildTrainPurchasePrice() {
        TrainPurchasePrice trainPurchasePrice = TrainPurchasePriceFactory.buildTrainPurchasePrice("452", "2016", "160000");
        System.out.println(trainPurchasePrice);
        Assert.assertNotNull(trainPurchasePrice.getTrainPurchasePriceId());
    }
}
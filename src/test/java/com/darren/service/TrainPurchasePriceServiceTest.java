package com.darren.service;

import com.darren.domain.TrainPurchasePrice;
import com.darren.factories.TrainPurchasePriceFactory;
import com.darren.repositories.impl.TrainPurchasePriceRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Set;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration
@RunWith(SpringRunner.class)
public class TrainPurchasePriceServiceTest {

    private TrainPurchasePriceRepositoryImpl repository;
    private TrainPurchasePrice trainPurchasePrice;


    @Before
    public void setUp() throws Exception {
        this.repository = TrainPurchasePriceRepositoryImpl.getRepository();
        this.trainPurchasePrice = TrainPurchasePriceFactory.buildTrainPurchasePrice("452", "2016", "160000");
    }

    @Test
    public void getAll() {
        Set<TrainPurchasePrice> trainPurchasePrice = this.repository.getAll();
        System.out.println("In getall, all = " + trainPurchasePrice);
    }

}

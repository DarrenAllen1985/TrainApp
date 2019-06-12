package com.darren.service;

import com.darren.domain.TrainStation;
import com.darren.factories.TrainStationFactory;
import com.darren.repositories.impl.TrainStationRepositoryImpl;
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
public class TrainStationServiceTest {

    private TrainStationRepositoryImpl repository;
    private TrainStation trainStation;


    @Before
    public void setUp() throws Exception {
        this.repository = TrainStationRepositoryImpl.getRepository();
        this.trainStation = TrainStationFactory.buildTrainStation("123", "TestBranch", "TestManager");
    }

    @Test
    public void getAll() {
        Set<TrainStation> trainStation = this.repository.getAll();
        System.out.println("In getall, all = " + trainStation);
    }

}

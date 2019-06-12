package com.darren.service;


import com.darren.domain.Train;
import com.darren.factories.TrainFactory;
import com.darren.repositories.impl.TrainRepositoryImpl;
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
public class TrainServiceTest {

    private TrainRepositoryImpl repository;
    private Train train;


    @Before
    public void setUp() throws Exception {
        this.repository = TrainRepositoryImpl.getRepository();
        this.train = TrainFactory.buildTrain("123456", "13443975", "MAN", "G666", "2016");
    }

    @Test
    public void getAll() {
        Set<Train> train = this.repository.getAll();
        System.out.println("In getall, all = " + train);
    }

}

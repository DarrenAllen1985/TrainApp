package com.darren.factories;


import com.darren.domain.Train;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TrainFactoryTest {

    public void testBuildTrain(){

    }

    private String TrainTest;

    @Before
    public void setUp() throws Exception {
        this.TrainTest = "TrainTest";
    }

    @Test
    public void buildTrain() {
        Train train = TrainFactory.buildTrain("123456", "13443975", "Man", "G666", "2016");
        System.out.println(train);
        Assert.assertNotNull(train.getTrainId());
    }
}

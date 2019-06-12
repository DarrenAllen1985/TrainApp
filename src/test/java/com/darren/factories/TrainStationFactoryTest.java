package com.darren.factories;

import com.darren.domain.TrainStation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainStationFactoryTest {

    public void testBuildTrainStation() {
    }

    private String TrainStationTest;

    @Before
    public void setUp() throws Exception {
        this.TrainStationTest = "TrainStationTest";
    }

    @Test
    public void buildTrainStation() {
        TrainStation trainStation = TrainStationFactory.buildTrainStation("123", "TestBranch", "TestManager");
        System.out.println(trainStation);
        Assert.assertNotNull(trainStation.getTrainStationId());
    }
}
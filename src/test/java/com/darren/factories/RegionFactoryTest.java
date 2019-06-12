package com.darren.factories;

import com.darren.domain.Region;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegionFactoryTest {

    public void testBuildRegion(){

    }

    private String RegionTest;

    @Before
    public void setUp() throws Exception {
        this.RegionTest = "RegionTest";
    }

    @Test
    public void buildRegion() {
        Region region = RegionFactory.buildRegion("765", "JHB", "JHB");
        System.out.println(region);
        Assert.assertNotNull(region.getRegionId());
    }
}

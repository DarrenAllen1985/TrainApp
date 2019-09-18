package com.darren.factories;


import com.darren.domain.Services;
import org.junit.Assert;
import org.junit.Test;

public class ServicesFactoryTest {

    @Test
    public void createServices() {
        Services services = ServicesFactory.createServices("0001", "Express",
                "Express", 2000.00);
        Assert.assertEquals("Express", services.getServiceName());
    }
}
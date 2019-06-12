package com.darren.factories;

import com.darren.domain.Address;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressFactoryTest extends TestCase {
    public void testBuildAddress() {
    }

    private String AddressTest;

    @Before
    public void setUp() throws Exception {
        this.AddressTest = "AddressTest";
    }

    @Test
    public void buildAddress() {
        Address address = AddressFactory.buildAddress("123", "75", "Main Road", "Cape Town", "8000", "Cape Town");
        System.out.println(address);
        Assert.assertNotNull(address.getAddressId());
    }
}
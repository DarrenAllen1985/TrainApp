package com.darren.factories;

import com.darren.domain.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerFactoryTest {

    public void testBuildCustomer(){

    }

    private String CustomerTest;

    @Before
    public void setUp() throws Exception {
        this.CustomerTest = "CustomerTest";
    }

    @Test
    public void buildCustomer() {
        Customer customer = CustomerFactory.buildCustomer("1234", "082123456789", "Customerele", "test@customerele.com", "customerele.co.za", "1 Street Road");
        System.out.println(customer);
        Assert.assertNotNull(customer.getCustomerId());
    }
}


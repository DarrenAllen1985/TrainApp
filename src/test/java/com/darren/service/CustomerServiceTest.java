package com.darren.service;


import com.darren.domain.Customer;
import com.darren.factories.CustomerFactory;
import com.darren.repositories.impl.CustomerRepositoryImpl;
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
public class CustomerServiceTest {

    private CustomerRepositoryImpl repository;
    private Customer customer;


    @Before
    public void setUp() throws Exception {
        this.repository = CustomerRepositoryImpl.getRepository();
        this.customer = CustomerFactory.buildCustomer("1234", "082123456789", "Customerele", "test@customerele.com", "Customer.co.za", "1 Street Road");
    }

    @Test
    public void getAll() {
        Set<Customer> customer = this.repository.getAll();
        System.out.println("In getall, all = " + customer);
    }

}

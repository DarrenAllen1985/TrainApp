package com.darren.service;

import com.darren.domain.Address;
import com.darren.factories.AddressFactory;
import com.darren.repositories.impl.AddressRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration
@RunWith(SpringRunner.class)
public class AddressServiceTest {
    private AddressRepositoryImpl repository;
    private Address address;


    @Before
    public void setUp() throws Exception {
        this.repository = AddressRepositoryImpl.getRepository();
        this.address = AddressFactory.buildAddress("123", "11", "Main Road", "Cape Town", "8000", "Cape Town");
    }

    @Test
    public void getAll() {
        Set<Address> address = this.repository.getAll();
        System.out.println("In getall, all = " + address);
    }

}
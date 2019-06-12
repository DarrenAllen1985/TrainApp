package com.darren.service;

import com.darren.domain.Revenue;
import com.darren.factories.RevenueFactory;
import com.darren.repositories.impl.RevenueRepositoryImpl;
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
public class RevenueServiceTest {

    private RevenueRepositoryImpl repository;
    private Revenue revenue;


    @Before
    public void setUp() throws Exception {
        this.repository = RevenueRepositoryImpl.getRepository();
        this.revenue = RevenueFactory.buildRevenue("345", "August", "April", "200000", "Cape Town");
    }

    @Test
    public void getAll() {
        Set<Revenue> revenue = this.repository.getAll();
        System.out.println("In getall, all = " + revenue);
    }

}

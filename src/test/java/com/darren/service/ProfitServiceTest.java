package com.darren.service;

import com.darren.domain.Profit;
import com.darren.factories.ProfitFactory;
import com.darren.repositories.impl.ProfitRepositoryImpl;
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
public class ProfitServiceTest {

    private ProfitRepositoryImpl repository;
    private Profit profit;


    @Before
    public void setUp() throws Exception {
        this.repository = ProfitRepositoryImpl.getRepository();
        this.profit = ProfitFactory.buildProfit("789", "100000", "120000");
    }

    @Test
    public void getAll() {
        Set<Profit> profit = this.repository.getAll();
        System.out.println("In getall, all = " + profit);
    }

}

package com.darren.service;

import com.darren.domain.Teller;
import com.darren.factories.TellerFactory;
import com.darren.repositories.impl.TellerRepositoryImpl;
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
public class TellerServiceTest {

    private TellerRepositoryImpl repository;
    private Teller teller;


    @Before
    public void setUp() throws Exception {
        this.repository = TellerRepositoryImpl.getRepository();
        this.teller = TellerFactory.buildTeller("123", "TellerUser", "Password123");
    }

    @Test
    public void getAll() {
        Set<Teller> teller = this.repository.getAll();
        System.out.println("In getall, all = " + teller);
    }

}

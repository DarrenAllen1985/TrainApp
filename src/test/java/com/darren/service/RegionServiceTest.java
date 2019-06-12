package com.darren.service;

import com.darren.domain.Region;
import com.darren.factories.RegionFactory;
import com.darren.repositories.impl.RegionRepositoryImpl;
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
public class RegionServiceTest {

    private RegionRepositoryImpl repository;
    private Region region;


    @Before
    public void setUp() throws Exception {
        this.repository = RegionRepositoryImpl.getRepository();
        this.region = RegionFactory.buildRegion("765", "JHB", "JHB");
    }

    @Test
    public void getAll() {
        Set<Region> region = this.repository.getAll();
        System.out.println("In getall, all = " + region);
    }

}

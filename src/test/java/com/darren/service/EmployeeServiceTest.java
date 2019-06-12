package com.darren.service;

import com.darren.domain.Employee;
import com.darren.factories.EmployeeFactory;
import com.darren.repositories.impl.EmployeeRepositoryImpl;
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
public class EmployeeServiceTest {

    private EmployeeRepositoryImpl repository;
    private Employee employee;


    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.buildEmployee("345", "August", "April", "200000", "Cape Town");
    }

    @Test
    public void getAll() {
        Set<Employee> employee = this.repository.getAll();
        System.out.println("In getall, all = " + employee);
    }

}

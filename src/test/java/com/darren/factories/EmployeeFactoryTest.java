package com.darren.factories;

import com.darren.domain.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeFactoryTest {

    public void testBuildEmployee(){

    }

    private String EmployeeTest;

    @Before
    public void setUp() throws Exception {
        this.EmployeeTest = "EmployeeTest";
    }

    @Test
    public void buildEmployee() {
        Employee employee = EmployeeFactory.buildEmployee("345", "August", "April", "200000", "Cape Town");
        System.out.println(employee);
        Assert.assertNotNull(employee.getEmployeeId());
    }
}
package com.darren.factories;


import com.darren.domain.JobRole;
import org.junit.Assert;
import org.junit.Test;

public class JobRoleFactoryTest {

    @Test
    public void createJobRole() {
        JobRole jobRole = JobRoleFactory.createJobRole("0001", "Conductor", 2000.00);
        Assert.assertEquals("Runner", jobRole.getJobRoleDescription());
    }
}
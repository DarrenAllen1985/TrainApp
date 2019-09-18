package com.darren.factories;

import com.darren.domain.Admin;
import org.junit.Assert;
import org.junit.Test;

public class AdminFactoryTest {

    @Test
    public void createAdmin() {
        Admin admin = AdminFactory.createAdmin("0001", "Darren", "Pass.123");
        Assert.assertEquals("Darren", admin.getAdminLogin());
    }
}
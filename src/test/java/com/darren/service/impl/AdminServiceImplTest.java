package com.darren.service.impl;


import com.darren.domain.Admin;
import com.darren.factories.AdminFactory;
import com.darren.service.AdminService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminServiceImplTest {
    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;
    private Admin admin;
    private Set<Admin> admins = new HashSet<>();

    @Before
    public void setUp() {
        admin = adminService.create(AdminFactory.createAdmin("0001",
                "Darren", "Pass.123"));
        admins.add(admin);
    }

    @Test
    public void create() {
        Admin createAdmin = adminService.create(AdminFactory.createAdmin("0002",
                "Tarryn", "Pass.657"));
        admins.add(createAdmin);
        Assert.assertEquals(createAdmin, adminService.read(createAdmin.getAdminId()));
    }

    @Test
    public void read() {
        Admin readAdmin = adminService.read(admin.getAdminId());
        Assert.assertEquals(readAdmin, adminService.read(readAdmin.getAdminId()));
    }

    @Test
    public void update() {
        String newAdminLogin = "Jenna";
        Admin updateAdmin = adminService.update(new Admin.Builder().copy(admin)
                .adminLogin(newAdminLogin).build());
        admins.add(updateAdmin);
        Assert.assertEquals(updateAdmin, adminService.read(updateAdmin.getAdminId()));
    }

    @Test
    public void delete() {
        admins.addAll(adminService.getAll());
        Admin deleteAdmin = adminService.create(AdminFactory.createAdmin("0547",
                "Tammy", "Yolo"));
        admins.add(deleteAdmin);
        admins.remove(deleteAdmin);
        adminService.delete(deleteAdmin.getAdminId());
        Assert.assertEquals(admins.size(), adminService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Admin> adminSet = adminService.getAll();
        Assert.assertEquals(adminSet.size(), adminService.getAll().size());
    }
}
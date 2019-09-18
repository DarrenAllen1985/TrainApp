package com.darren.service.impl;


import com.darren.domain.Login;
import com.darren.factories.LoginFactory;
import com.darren.service.LoginService;
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
public class LoginServiceImplTest {
    @Autowired
    @Qualifier("LoginServiceImpl")
    private LoginService loginService;
    private Login login;
    private Set<Login> logins = new HashSet<>();

    @Before
    public void setUp() {
        login = loginService.create(LoginFactory.createLogin("0001", "Darren", "Pass.123"));
        logins.add(login);
    }

    @Test
    public void create() {
        Login createLogin = loginService.create(LoginFactory.createLogin("0001", "Rhea",
                "Yolo"));
        logins.add(createLogin);
        Assert.assertEquals(createLogin, loginService.read(createLogin.getLoginId()));
    }

    @Test
    public void read() {
        Login readLogin = loginService.read(login.getLoginId());
        Assert.assertEquals(readLogin, loginService.read(readLogin.getLoginId()));
    }

    @Test
    public void update() {
        String newLoginName = "Tarryn";
        Login updateLogin = loginService.update(new Login.Builder().copy(login).loginName(newLoginName).build());
        logins.add(updateLogin);
        Assert.assertEquals(updateLogin, loginService.read(updateLogin.getLoginId()));
    }

    @Test
    public void delete() {
        logins.addAll(loginService.getAll());
        Login deleteLogin = loginService.create(LoginFactory.createLogin("0056", "Tarryn",
                "WorldWarZ"));
        logins.add(deleteLogin);
        logins.remove(deleteLogin);
        loginService.delete(deleteLogin.getLoginId());
        Assert.assertEquals(logins.size(), loginService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Login> loginSet = loginService.getAll();
        Assert.assertEquals(loginSet.size(), loginService.getAll().size());
    }
}
package com.darren.factories;


import com.darren.domain.Login;
import org.junit.Assert;
import org.junit.Test;

public class LoginFactoryTest {

    @Test
    public void createLogin() {
        Login login = LoginFactory.createLogin("0001", "Darren", "Tarryn");
        Assert.assertEquals("Darren", login.getLoginName());
    }
}
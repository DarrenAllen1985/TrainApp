package com.darren.factories;


import com.darren.domain.Login;

public class LoginFactory {

    public static Login createLogin(String loginId, String loginName, String password) {
        return new Login.Builder()
                .loginId(loginId)
                .loginName(loginName)
                .password(password)
                .build();
    }
}
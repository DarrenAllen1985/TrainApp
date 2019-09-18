package com.darren.service.impl;


import com.darren.domain.Login;
import com.darren.repositories.LoginRepository;
import com.darren.repositories.impl.LoginRepositoryImpl;
import com.darren.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;

    private LoginServiceImpl() {
        this.loginRepository = LoginRepositoryImpl.getLoginRepository();
    }

    @Override
    public Login create(Login login) {
        return this.loginRepository.create(login);
    }

    @Override
    public Login read(String loginId) {
        return this.loginRepository.read(loginId);
    }

    @Override
    public Login update(Login login) {
        return this.loginRepository.update(login);
    }

    @Override
    public void delete(String loginId) {
        this.loginRepository.delete(loginId);
    }

    @Override
    public Set<Login> getAll() {
        return this.loginRepository.getAll();
    }
}
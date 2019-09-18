package com.darren.service;


import com.darren.domain.Login;

import java.util.Set;

public interface LoginService extends CrudService<Login, String> {
    Set<Login> getAll();
}
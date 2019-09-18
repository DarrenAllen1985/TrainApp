package com.darren.repositories;


import com.darren.domain.Login;

import java.util.Set;

public interface LoginRepository extends CrudRepository<Login, String> {
    Set<Login> getAll();
}
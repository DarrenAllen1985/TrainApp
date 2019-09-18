package com.darren.service;


import com.darren.domain.Admin;

import java.util.Set;

public interface AdminService extends CrudService<Admin, String> {
    Set<Admin> getAll();
}
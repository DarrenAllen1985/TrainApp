package com.darren.service;


import com.darren.domain.Permission;

import java.util.Set;

public interface PermissionService extends CrudService<Permission, String> {
    Set<Permission> getAll();
}
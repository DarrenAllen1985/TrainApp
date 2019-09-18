package com.darren.repositories;


import com.darren.domain.Permission;

import java.util.Set;

public interface PermissionRepository extends CrudRepository<Permission, String> {
    Set<Permission> getAll();
}
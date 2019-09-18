package com.darren.service.impl;


import com.darren.domain.Permission;
import com.darren.repositories.PermissionRepository;
import com.darren.repositories.impl.PermissionRepositoryImpl;
import com.darren.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("PermissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    private PermissionServiceImpl() {
        this.permissionRepository = PermissionRepositoryImpl.getPermissionRepository();
    }
    @Override
    public Permission create(Permission permission) {
        return this.permissionRepository.create(permission);
    }

    @Override
    public Permission read(String permissionId) {
        return this.permissionRepository.read(permissionId);
    }

    @Override
    public Permission update(Permission permission) {
        return this.permissionRepository.update(permission);
    }

    @Override
    public void delete(String permissionId) {
        this.permissionRepository.delete(permissionId);
    }

    @Override
    public Set<Permission> getAll() {
        return this.permissionRepository.getAll();
    }

}

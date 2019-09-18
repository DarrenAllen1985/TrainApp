package com.darren.service.impl;


import com.darren.domain.Admin;
import com.darren.repositories.AdminRepository;
import com.darren.repositories.impl.AdminRepositoryImpl;
import com.darren.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    private AdminServiceImpl() {
        this.adminRepository = AdminRepositoryImpl.getAdminRepository();
    }

    @Override
    public Admin create(Admin admin) {
        return this.adminRepository.create(admin);
    }

    @Override
    public Admin read(String adminId) {
        return this.adminRepository.read(adminId);
    }

    @Override
    public Admin update(Admin admin) {
        return this.adminRepository.update(admin);
    }

    @Override
    public void delete(String adminId) {
        this.adminRepository.delete(adminId);
    }

    @Override
    public Set<Admin> getAll() {
        return this.adminRepository.getAll();
    }
}
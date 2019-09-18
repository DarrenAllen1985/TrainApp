package com.darren.service.impl;

import com.darren.domain.Employee;
import com.darren.domain.Website;
import com.darren.repositories.EmployeeRepository;
import com.darren.repositories.impl.EmployeeRepositoryImpl;
import com.darren.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    private EmployeeServiceImpl() {
        this.employeeRepository = EmployeeRepositoryImpl.getRepository();
    }

    /*public static EmployeeServiceImpl getService(){
        if (service == null) service = new EmployeeServiceImpl();
        return service;
    }*/

    @Override
    public Employee create(Employee smployee) {
        return this.employeeRepository.create(smployee);
    }

    @Override
    public Employee update(Employee smployee) {
        return this.employeeRepository.update(smployee);
    }

    @Override
    public void delete(String s) {
        this.employeeRepository.delete(s);
    }

    @Override
    public Employee read(String s) {
        return this.employeeRepository.read(s);
    }

    @Override
    public Set<Employee> getAll() {
        return this.employeeRepository.getAll();
    }
}

package com.darren.service;

import com.darren.domain.Employee;

import java.util.Set;

public interface EmployeeService extends CrudService<Employee, String>{
    Set<Employee> getAll();
}

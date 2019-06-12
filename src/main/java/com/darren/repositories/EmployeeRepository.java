package com.darren.repositories;

import com.darren.domain.Employee;

import java.util.Set;


public interface EmployeeRepository extends CrudRepository<Employee, String> {

    Set<Employee> getAll();
}

package com.darren.repositories.impl;

import com.darren.domain.Employee;
import com.darren.repositories.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl repository = null;
    private Set<Employee> employee;

    private EmployeeRepositoryImpl(){
        this.employee = new HashSet<>();
    }

    private Employee findEmployee(String employeeId) {
        return this.employee.stream()
                .filter(employee -> employee.getEmployeeId().trim().equals(employeeId))
                .findAny()
                .orElse(null);
    }

    public static EmployeeRepositoryImpl getRepository(){
        if (repository == null) repository = new EmployeeRepositoryImpl();
        return repository;
    }


    public Employee create(Employee employee){
        this.employee.add(employee);
        return employee;
    }

    public Employee read(final String employeeId){
        Employee employee = findEmployee(employeeId);
        return employee;
    }

    public void delete(String employeeId) {
        Employee employee = findEmployee(employeeId);
        if (employee != null) this.employee.remove(employee);
    }

    public Employee update(Employee employee){
        Employee toDelete = findEmployee(employee.getEmployeeId());
        if(toDelete != null) {
            this.employee.remove(toDelete);
            return create(employee);
        }
        return null;
    }


    public Set<Employee> getAll(){
        return this.employee;
    }
}

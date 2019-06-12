package com.darren.factories;

import com.darren.domain.Employee;

public class EmployeeFactory {

    //Changes to be made, in future iteration remove String employeeId and have the String employeeId generated.
    public static Employee buildEmployee(String employeeId, String employeeName, String employeeContact, String employeeEmail, String employeeIDNumber)
    {
        Employee employee = new Employee.Builder()
                .employeeId(employeeId)
                .employeeName(employeeName)
                .employeeContact(employeeContact)
                .employeeEmail(employeeEmail)
                .employeeIDNumber(employeeIDNumber)
                .build();
        return employee;
    }
}

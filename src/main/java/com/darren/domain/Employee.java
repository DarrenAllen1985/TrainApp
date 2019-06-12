package com.darren.domain;

public class Employee {

    private String employeeId;
    private String employeeName;
    private String employeeContact;
    private String employeeEmail;
    private String employeeIDNumber;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeIDNumber() {
        return employeeIDNumber;
    }

    public void setEmployeeIDNumber(String employeeIDNumber) {
        this.employeeIDNumber = employeeIDNumber;
    }


    private Employee(){

    }

    public Employee(Builder builder) {
        this.employeeId = builder.employeeId;
        this.employeeName = builder.employeeName;
        this.employeeContact = builder.employeeContact;
        this.employeeEmail = builder.employeeEmail;
        this.employeeIDNumber = builder.employeeIDNumber;
    }

    public static class Builder{

        private String employeeId;
        private String employeeName;
        private String employeeContact;
        private String employeeEmail;
        private String employeeIDNumber;

        public Builder employeeId(String value)
        {
            this.employeeId = value;
            return this;
        }

        public Builder employeeName(String value)
        {
            this.employeeName = value;
            return this;
        }

        public Builder employeeContact(String value)
        {
            this.employeeContact = value;
            return this;
        }

        public Builder employeeEmail(String value)
        {
            this.employeeEmail = value;
            return this;
        }

        public Builder employeeIDNumber(String value)
        {
            this.employeeIDNumber = value;
            return this;
        }

        public Employee build(){

            return new Employee(this);
        }

        public Builder copy(Employee savedEmployee) {
            this.employeeId = savedEmployee.employeeId;
            this.employeeName = savedEmployee.employeeName;
            this.employeeContact = savedEmployee.employeeContact;
            this.employeeEmail = savedEmployee.employeeEmail;
            this.employeeIDNumber = savedEmployee.employeeIDNumber;

            return this;
        }
    }
}

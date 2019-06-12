package com.darren.domain;

public class Customer {

    private String customerId;
    private String customerCell;
    private String customerName;
    private String customerEmail;
    private String customerWebsite;
    private String customerAddress;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCell() {
        return customerCell;
    }

    public void setCustomerCell(String customerCell) {
        this.customerCell = customerCell;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerWebsite() {
        return customerWebsite;
    }

    public void setCustomerWebsite(String customerWebsite) {
        this.customerWebsite = customerWebsite;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    private Customer(){

    }

    public Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.customerCell = builder.customerCell;
        this.customerName = builder.customerName;
        this.customerEmail = builder.customerEmail;
        this.customerWebsite = builder.customerWebsite;
        this.customerAddress = builder.customerAddress;
    }

    public static class Builder{

        private String customerId;
        private String customerCell;
        private String customerName;
        private String customerEmail;
        private String customerWebsite;
        private String customerAddress;

        public Builder customerId(String value)
        {
            this.customerId = value;
            return this;
        }

        public Builder customerCell(String value)
        {
            this.customerCell = value;
            return this;
        }

        public Builder customerName(String value)
        {
            this.customerName = value;
            return this;
        }

        public Builder customerEmail(String value)
        {
            this.customerEmail = value;
            return this;
        }

        public Builder customerWebsite(String value)
        {
            this.customerWebsite = value;
            return this;
        }

        public Builder customerAddress(String value)
        {
            this.customerAddress = value;
            return this;
        }

        public Customer build(){

            return new Customer(this);
        }

        public Builder copy(Customer savedCustomer) {
            this.customerId = savedCustomer.customerId;
            this.customerCell = savedCustomer.customerCell;
            this.customerName = savedCustomer.customerName;
            this.customerEmail = savedCustomer.customerEmail;
            this.customerWebsite = savedCustomer.customerWebsite;
            this.customerAddress = savedCustomer.customerAddress;

            return this;
        }
    }
}

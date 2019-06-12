package com.darren.factories;

import com.darren.domain.Customer;

public class CustomerFactory {

    public static Customer buildCustomer(String customerId, String customerCell, String customerName, String customerEmail, String customerWebsite, String customerAddress)
    {
        Customer customer = new Customer.Builder()
                .customerId(customerId)
                .customerCell(customerCell)
                .customerName(customerName)
                .customerEmail(customerEmail)
                .customerWebsite(customerWebsite)
                .customerAddress(customerAddress)
                .build();
        return customer;
    }
}

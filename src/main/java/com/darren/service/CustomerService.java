package com.darren.service;

import com.darren.domain.Customer;

import java.util.Set;

public interface CustomerService extends CrudService<Customer, String>{
    Set<Customer> getAll();
}

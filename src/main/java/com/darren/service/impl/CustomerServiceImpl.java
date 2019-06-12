package com.darren.service.impl;

import com.darren.domain.Customer;
import com.darren.repositories.CustomerRepository;
import com.darren.repositories.impl.CustomerRepositoryImpl;
import com.darren.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
    @Autowired

    private static CustomerServiceImpl service = null;
    private CustomerRepository repository;

    private CustomerServiceImpl() {
        this.repository = CustomerRepositoryImpl.getRepository();
    }

    public static CustomerServiceImpl getService(){
        if (service == null) service = new CustomerServiceImpl();
        return service;
    }

    @Override
    public Customer create(Customer customer) {
        return this.repository.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return this.repository.update(customer);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Customer read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Customer> getAll() {
        return this.repository.getAll();
    }
}

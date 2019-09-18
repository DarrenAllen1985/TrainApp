package com.darren.service.impl;

import com.darren.domain.Customer;
import com.darren.repositories.CustomerRepository;
import com.darren.repositories.impl.CustomerRepositoryImpl;
import com.darren.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private CustomerServiceImpl() {
        this.customerRepository = CustomerRepositoryImpl.getRepository();
    }

   /* public static CustomerServiceImpl getService(){
        if (service == null) service = new CustomerServiceImpl();
        return service;
    }*/

    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepository.update(customer);
    }

    @Override
    public void delete(String s) {
        this.customerRepository.delete(s);
    }

    @Override
    public Customer read(String s) {
        return this.customerRepository.read(s);
    }

    @Override
    public Set<Customer> getAll() {
        return this.customerRepository.getAll();
    }
}

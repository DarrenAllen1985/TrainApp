package com.darren.repositories.impl;

import com.darren.domain.Customer;
import com.darren.repositories.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static CustomerRepositoryImpl repository = null;
    private Set<Customer> customer;

    private CustomerRepositoryImpl(){
        this.customer = new HashSet<>();
    }

    private Customer findCustomer(String customerId) {
        return this.customer.stream()
                .filter(customer -> customer.getCustomerId().trim().equals(customerId))
                .findAny()
                .orElse(null);
    }

    public static CustomerRepositoryImpl getRepository(){
        if (repository == null) repository = new CustomerRepositoryImpl();
        return repository;
    }


    public Customer create(Customer customer){
        this.customer.add(customer);
        return customer;
    }

    public Customer read(final String customerId){
        Customer customer = findCustomer(customerId);
        return customer;
    }

    public void delete(String customerId) {
        Customer customer = findCustomer(customerId);
        if (customer != null) this.customer.remove(customer);
    }

    public Customer update(Customer customer){
        Customer toDelete = findCustomer(customer.getCustomerId());
        if(toDelete != null) {
            this.customer.remove(toDelete);
            return create(customer);
        }
        return null;
    }


    public Set<Customer> getAll(){
        return this.customer;
    }
}

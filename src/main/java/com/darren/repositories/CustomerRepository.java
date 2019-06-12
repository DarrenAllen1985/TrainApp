package com.darren.repositories;

import com.darren.domain.Customer;

import java.util.Set;


public interface CustomerRepository extends CrudRepository<Customer, String> {

    Set<Customer> getAll();
    //public List<Customer> findByAge(int age);
    //public List<Customer> findById(String id);

}

package com.darren.repositories;

import com.darren.domain.Address;

import java.util.Set;


public interface AddressRepository extends CrudRepository<Address, String> {

    Set<Address> getAll();
    //public List<Address> findByAge(int age);
    //public List<Address> findById(String id);

}

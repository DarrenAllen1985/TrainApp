package com.darren.service;

import com.darren.domain.Address;

import java.util.Set;

public interface AddressService extends CrudService<Address, String>{
    Set<Address> getAll();
}
package com.darren.repositories;


import com.darren.domain.Contact;

import java.util.Set;

public interface ContactRepository extends CrudRepository<Contact, String> {
    Set<Contact> getAll();
}

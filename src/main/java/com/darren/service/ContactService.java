package com.darren.service;

import com.darren.domain.Contact;

import java.util.Set;

public interface ContactService extends CrudService<Contact, String> {
    Set<Contact> getAll();
}
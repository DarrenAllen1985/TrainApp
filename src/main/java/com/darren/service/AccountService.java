package com.darren.service;


import com.darren.domain.Account;

import java.util.Set;

public interface AccountService extends CrudService<Account, String> {
    Set<Account> getAll();
}
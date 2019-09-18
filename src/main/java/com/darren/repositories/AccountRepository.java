package com.darren.repositories;

import com.darren.domain.Account;

import java.util.Set;
public interface AccountRepository extends CrudRepository<Account, String> {
    Set<Account> getAll();
}

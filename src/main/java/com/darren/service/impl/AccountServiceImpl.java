package com.darren.service.impl;


import com.darren.domain.Account;
import com.darren.repositories.AccountRepository;
import com.darren.repositories.impl.AccountRepositoryImpl;
import com.darren.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AccountServiceImpl")
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    private AccountServiceImpl() {
        this.accountRepository = AccountRepositoryImpl.getAccountRepository();
    }

    @Override
    public Set<Account> getAll() {
        return this.accountRepository.getAll();
    }

    @Override
    public Account create(Account account) {
        return this.accountRepository.create(account);
    }

    @Override
    public Account read(String accountId) {
        return this.accountRepository.read(accountId);
    }

    @Override
    public Account update(Account account) {
        return this.accountRepository.update(account);
    }

    @Override
    public void delete(String accountId) {
        this.accountRepository.delete(accountId);
    }
}
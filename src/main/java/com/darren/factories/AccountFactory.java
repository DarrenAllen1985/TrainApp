package com.darren.factories;


import com.darren.domain.Account;

public class AccountFactory {
    public static Account createAccount(String accountId, String accountNumber,
                                        String accountName, String accountCategory) {
        return new Account.Builder()
                .accountId(accountId)
                .acccountName(accountName)
                .accountNumber(accountNumber)
                .accountCategory(accountCategory)
                .build();
    }
}
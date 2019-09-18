package com.darren.factories;


import com.darren.domain.Account;
import org.junit.Assert;
import org.junit.Test;

public class AccountFactoryTest {

    @Test
    public void createAccount() {
        Account account = AccountFactory.createAccount("0001", "1234", "Train Expense",
                "Express");
        Assert.assertEquals("Train Expense", account.getAccountName());
    }
}
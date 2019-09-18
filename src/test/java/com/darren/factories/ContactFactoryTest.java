package com.darren.factories;


import com.darren.domain.Contact;
import org.junit.Assert;
import org.junit.Test;

public class ContactFactoryTest {

    @Test
    public void createContact() {
        Contact contact = ContactFactory.createContact("0001", "Darren@gmail.com",
                "0730853333", "021123456");
        Assert.assertEquals("0001", contact.getContactId());
    }
}
package com.darren.repositories.impl;

import com.darren.domain.Customer;
import com.darren.factories.CustomerFactory;
import com.darren.repositories.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerRepositoryImplTest {

    private CustomerRepository repository;
    private Customer customer;

    private Customer getSavedCustomer() {
        Set<Customer> savedCustomers = this.repository.getAll();
        return savedCustomers.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CustomerRepositoryImpl.getRepository();
        this.customer = CustomerFactory.buildCustomer("1234", "082123456789", "Customerele", "test@customerele.com", "customerele.co.za", "1 Street Road");
    }

    @Test
    public void a_create() {
        Customer created = this.repository.create(this.customer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.customer);
    }

    @Test
    public void b_read() {
       Customer savedCustomer = getSavedCustomer();
        System.out.println("In read, customerId = "+ savedCustomer.getCustomerId());
        Customer read = this.repository.read(savedCustomer.getCustomerId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedCustomer, read);
    }

    @Test
    public void e_delete() {
        Customer savedCustomer = getSavedCustomer();
        this.repository.delete(savedCustomer.getCustomerId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Customer Name";
        Customer customer = new Customer.Builder().copy(getSavedCustomer()).customerName(newname).build();
        System.out.println("In update, about_to_updated = " + customer);
        Customer updated = this.repository.update(customer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getCustomerName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Customer> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}

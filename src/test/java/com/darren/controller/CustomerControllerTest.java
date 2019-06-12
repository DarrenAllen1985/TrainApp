package com.darren.controller;

import com.darren.domain.Customer;
import com.darren.factories.CustomerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class CustomerControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/customer";


    @Test
    public void testGetAllCustomer() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = restTemplate.getForObject(baseURL + "/customer/1", Customer.class);
        System.out.println(customer.getCustomerId());
        assertNotNull(customer);
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = CustomerFactory.buildCustomer("1234", "082123456789", "Customerele", "test@customerele.com", "customerele.co.za", "1 Street Road");
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(baseURL + "/create", customer, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateCustomer() {
        int id = 1;
        Customer customer = restTemplate.getForObject(baseURL + "/customer/" + id, Customer.class);

        restTemplate.put(baseURL + "/customer/" + id, customer);
        Customer updatedCustomer = restTemplate.getForObject(baseURL + "/Customer/" + id, Customer.class);
        assertNotNull(updatedCustomer);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Customer customer = restTemplate.getForObject(baseURL + "/customer/" + id, Customer.class);
        assertNotNull(customer);
        restTemplate.delete(baseURL + "/customer/" + id);

            customer = restTemplate.getForObject(baseURL + "/customer/" + id, Customer.class);
         }
}

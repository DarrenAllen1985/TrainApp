package com.darren.controller;

import com.darren.domain.Employee;
import com.darren.factories.EmployeeFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/address";


    @Test
    public void testGetAllEmployee() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetEmployeeById() {
        Employee address = restTemplate.getForObject(baseURL + "/address/1", Employee.class);
        System.out.println(address.getEmployeeId());
        assertNotNull(address);
    }

    @Test
    public void testCreateEmployee() {
        Employee address = EmployeeFactory.buildEmployee("345", "August", "April", "200000", "Claremont");
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(baseURL + "/create", address, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateEmployee() {
        int id = 1;
        Employee address = restTemplate.getForObject(baseURL + "/address/" + id, Employee.class);

        restTemplate.put(baseURL + "/address/" + id, address);
        Employee updatedEmployee = restTemplate.getForObject(baseURL + "/Employee/" + id, Employee.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Employee address = restTemplate.getForObject(baseURL + "/address/" + id, Employee.class);
        assertNotNull(address);
        restTemplate.delete(baseURL + "/address/" + id);
        try {
            address = restTemplate.getForObject(baseURL + "/address/" + id, Employee.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

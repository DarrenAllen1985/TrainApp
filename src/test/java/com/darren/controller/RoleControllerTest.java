package com.darren.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RoleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL ="http://localhost:8080/";
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin","password").postForEntity(baseURL+ "/create/all", entity,String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void getall() {
    }
}
package com.darren.controller;

import com.darren.domain.Teller;
import com.darren.factories.TellerFactory;
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
public class TellerControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/teller";


    @Test
    public void testGetAllTeller() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetTellerById() {
        Teller teller = restTemplate.getForObject(baseURL + "/teller/1", Teller.class);
        System.out.println(teller.getTellerId());
        assertNotNull(teller);
    }

    @Test
    public void testCreateTeller() {
        Teller teller = TellerFactory.buildTeller("123", "TellerUser", "Password123");
        ResponseEntity<Teller> postResponse = restTemplate.postForEntity(baseURL + "/create", teller, Teller.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateTeller() {
        int id = 1;
        Teller teller = restTemplate.getForObject(baseURL + "/teller/" + id, Teller.class);

        restTemplate.put(baseURL + "/teller/" + id, teller);
        Teller updatedTeller = restTemplate.getForObject(baseURL + "/Teller/" + id, Teller.class);
        assertNotNull(updatedTeller);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Teller teller = restTemplate.getForObject(baseURL + "/teller/" + id, Teller.class);
        assertNotNull(teller);
        restTemplate.delete(baseURL + "/teller/" + id);
        try {
            teller = restTemplate.getForObject(baseURL + "/teller/" + id, Teller.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

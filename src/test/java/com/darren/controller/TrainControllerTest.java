package com.darren.controller;


import com.darren.domain.Train;
import com.darren.factories.TrainFactory;
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
public class TrainControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/train";


    @Test
    public void testGetAllTrain() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetTrainById() {
        Train train = restTemplate.getForObject(baseURL + "/train/1", Train.class);
        System.out.println(train.getTrainId());
        assertNotNull(train);
    }

    @Test
    public void testCreateTrain() {
        Train train = TrainFactory.buildTrain("123456", "13443975", "Man", "g666", "2016");
        ResponseEntity<Train> postResponse = restTemplate.postForEntity(baseURL + "/create", train, Train.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateTrain() {
        int id = 1;
        Train train = restTemplate.getForObject(baseURL + "/train/" + id, Train.class);

        restTemplate.put(baseURL + "/train/" + id, train);
        Train updatedTrain = restTemplate.getForObject(baseURL + "/Train/" + id, Train.class);
        assertNotNull(updatedTrain);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Train train = restTemplate.getForObject(baseURL + "/train/" + id, Train.class);
        assertNotNull(train);
        restTemplate.delete(baseURL + "/train/" + id);
        try {
            train = restTemplate.getForObject(baseURL + "/train/" + id, Train.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

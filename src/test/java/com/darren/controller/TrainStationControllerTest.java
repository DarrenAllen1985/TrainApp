package com.darren.controller;

import com.darren.domain.TrainStation;
import com.darren.factories.TrainStationFactory;
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
public class TrainStationControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/trainStation";


    @Test
    public void testGetAllTrainStation() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetTrainStationById() {
        TrainStation trainStation = restTemplate.getForObject(baseURL + "/trainStation/1", TrainStation.class);
        System.out.println(trainStation.getTrainStationId());
        assertNotNull(trainStation);
    }

    @Test
    public void testCreateTrainStation() {
        TrainStation trainStation = TrainStationFactory.buildTrainStation("123", "TestBranch", "TestManager");
        ResponseEntity<TrainStation> postResponse = restTemplate.postForEntity(baseURL + "/create", trainStation, TrainStation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateTrainStation() {
        int id = 1;
        TrainStation trainStation = restTemplate.getForObject(baseURL + "/trainStation/" + id, TrainStation.class);

        restTemplate.put(baseURL + "/trainStation/" + id, trainStation);
        TrainStation updatedTrainStation = restTemplate.getForObject(baseURL + "/TrainStation/" + id, TrainStation.class);
        assertNotNull(updatedTrainStation);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        TrainStation trainStation = restTemplate.getForObject(baseURL + "/trainStation/" + id, TrainStation.class);
        assertNotNull(trainStation);
        restTemplate.delete(baseURL + "/trainStation/" + id);
        try {
            trainStation = restTemplate.getForObject(baseURL + "/trainStation/" + id, TrainStation.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

package com.darren.controller;

import com.darren.domain.TrainPurchasePrice;
import com.darren.factories.TrainPurchasePriceFactory;
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
public class TrainPurchasePriceControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/trainPurchasePrice";


    @Test
    public void testGetAllTrainPurchasePrice() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetTrainPurchasePriceById() {
        TrainPurchasePrice trainPurchasePrice = restTemplate.getForObject(baseURL + "/trainPurchasePrice/1", TrainPurchasePrice.class);
        System.out.println(trainPurchasePrice.getTrainPurchasePriceId());
        assertNotNull(trainPurchasePrice);
    }

    @Test
    public void testCreateTrainPurchasePrice() {
        TrainPurchasePrice trainPurchasePrice = TrainPurchasePriceFactory.buildTrainPurchasePrice("452", "2016", "160000");
        ResponseEntity<TrainPurchasePrice> postResponse = restTemplate.postForEntity(baseURL + "/create", trainPurchasePrice, TrainPurchasePrice.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateTrainPurchasePrice() {
        int id = 1;
        TrainPurchasePrice trainPurchasePrice = restTemplate.getForObject(baseURL + "/trainPurchasePrice/" + id, TrainPurchasePrice.class);

        restTemplate.put(baseURL + "/trainPurchasePrice/" + id, trainPurchasePrice);
        TrainPurchasePrice updatedTrainPurchasePrice = restTemplate.getForObject(baseURL + "/TrainPurchasePrice/" + id, TrainPurchasePrice.class);
        assertNotNull(updatedTrainPurchasePrice);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        TrainPurchasePrice trainPurchasePrice = restTemplate.getForObject(baseURL + "/trainPurchasePrice/" + id, TrainPurchasePrice.class);
        assertNotNull(trainPurchasePrice);
        restTemplate.delete(baseURL + "/trainPurchasePrice/" + id);
        try {
            trainPurchasePrice = restTemplate.getForObject(baseURL + "/trainPurchasePrice/" + id, TrainPurchasePrice.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

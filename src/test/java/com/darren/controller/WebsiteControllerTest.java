package com.darren.controller;

import com.darren.domain.Region;
import com.darren.domain.Website;
import com.darren.factories.RegionFactory;
import com.darren.factories.WebsiteFactory;
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
public class WebsiteControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/region";


    @Test
    public void testGetAllRegion() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetWebsite() {
        Website website = restTemplate.getForObject(baseURL + "/website/1", Website.class);
        System.out.println(website.getWebsiteName());
        assertNotNull(website);
    }

    @Test
    public void testCreateWebsite() {
        Website website = WebsiteFactory.buildWebsite("Brazzers", "Long", "LongJohn");
        ResponseEntity<Website> postResponse = restTemplate.postForEntity(baseURL + "/create", website, Website.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateWebsite () {
        String id = "fiverr";
        Website website = restTemplate.getForObject(baseURL + "/website/" + id, Website.class);

        restTemplate.put(baseURL + "/region/" + id, website);
        Website updatedWebsite = restTemplate.getForObject(baseURL + "/Region/" + id, Website.class);
        assertNotNull(updatedWebsite);
    }

    @Test
    public void testDeleteWebsite() {
        String id  = "fiverr";
        Website website= restTemplate.getForObject(baseURL + "/website/" + id, Website.class);
        assertNotNull(website);
        restTemplate.delete(baseURL + "/region/" + id);
        try {
            website  = restTemplate.getForObject(baseURL + "/website/" + id, Website.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

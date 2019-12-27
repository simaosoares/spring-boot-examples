package com.examples.web.sector_of_activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Integration tests for {@link SectorOfActivity}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SectorOfActivityIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void findAll_shouldListSectorsOfActivity() {

        final ResponseEntity<ArrayList<SectorOfActivity>> exchange = testRestTemplate
                .exchange("/sectorsOfActivity", HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<SectorOfActivity>>() {});

        assertTrue(exchange.getStatusCode().is2xxSuccessful());
        assertNotNull(exchange.getBody());
        assertEquals(2, exchange.getBody().size());
        assertEquals("Automotive & Transportation", exchange.getBody().get(0).getName());
    }

    @Test
    public void findByName_shouldReturnNotFound() {
        final ResponseEntity<SectorOfActivity> responseEntity = testRestTemplate
                .getForEntity("/sectorsOfActivity/{name}", SectorOfActivity.class, "does not exist");

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void findByName_shouldReturnSectorOfActivity() {
        final ResponseEntity<SectorOfActivity> responseEntity = testRestTemplate
                .getForEntity("/sectorsOfActivity/{name}", SectorOfActivity.class, "Electro-electronics & Telecoms");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void findBySearchTerm_shouldReturnSectorsOfActivity() {
        final String searchTerm = "Electro-electronics & Telecoms"; // our search term contains an "ampersand"

        final UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString("/sectorsOfActivity/findBySearchTerm")
                .queryParam("searchTerm", searchTerm)
                .encode(); // request to have the URI template and URI variables encoded

        final URI uri = uriBuilder.build()
                .toUri();

        final ResponseEntity<ArrayList<SectorOfActivity>> exchange = testRestTemplate
                .exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<SectorOfActivity>>() {});

        assertTrue(exchange.getStatusCode().is2xxSuccessful());
        assertNotNull(exchange.getBody());
        assertEquals(1, exchange.getBody().size());
        assertEquals(searchTerm, exchange.getBody().get(0).getName());
    }

}

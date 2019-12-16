package com.examples.web;

import org.junit.Test;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Unit test featuring {@link org.springframework.web.util.UriTemplate}
 */
public class UriTemplateTest {

    @Test
    public void uriTemplateWithVarargsTest() {
        short port = 8080;
        short id = 1;

        final URI expand = new UriTemplate("http://localhost:{port}/api/v1/resource/{id}")
                .expand(port, id);

        assertEquals("http://localhost:8080/api/v1/resource/1", expand.toString());
    }

    @Test
    public void uriTemplateWithMapStringTest() {
        UriTemplate template = new UriTemplate("https://example.com/hotels/{hotel}/bookings/{booking}");

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("booking", "42");
        uriVariables.put("hotel", "Rest & Relax");

        assertEquals("https://example.com/hotels/Rest%20&%20Relax/bookings/42", template.expand(uriVariables).toString());
    }
}

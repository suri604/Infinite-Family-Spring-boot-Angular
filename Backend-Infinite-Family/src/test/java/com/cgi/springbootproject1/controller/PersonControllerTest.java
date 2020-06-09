/**
 *
 */
package com.cgi.springbootproject1.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The Class PersonControllerTest.
 *
 * @author arun.suri
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest
{

    /** The rest template. */
    @Autowired
    private TestRestTemplate restTemplate;

    /** The port. */
    @LocalServerPort
    private int port;

    /**
     * Gets the root url.
     *
     * @return the root url
     */
    private String getRootUrl()
    {
        return "http://localhost:" + port;
    }

    /**
     * Context loads.
     */
    @Test
    public void contextLoads()
    {

    }

    /**
     * Test get all students.
     */
    @Test
    public void testGetAllStudents()
    {
        final HttpHeaders headers = new HttpHeaders();
        final HttpEntity<String> entity = new HttpEntity<>(null, headers);

        final ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/get/Persons", HttpMethod.GET,
                entity, String.class);

        assertNotNull(response.getBody());
    }
}

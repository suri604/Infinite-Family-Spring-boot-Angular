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

import com.cgi.springbootproject1.model.Student;

/**
 * The Class StudentControllerTest.
 *
 * @author arun.suri
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest
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
     * Test create student.
     */
    @Test
    public void testCreateStudent()
    {
        final Student student = new Student();
        student.setAge(10);
        student.setName("Arun");
        final ResponseEntity<Student> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/post/Persons",
                student, Student.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    /**
     * Test get all students.
     */
    @Test
    public void testGetAllStudents()
    {
        final HttpHeaders headers = new HttpHeaders();
        final HttpEntity<String> entity = new HttpEntity<>(null, headers);

        final ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getall/Students", HttpMethod.GET,
                entity, String.class);

        assertNotNull(response.getBody());
    }

}

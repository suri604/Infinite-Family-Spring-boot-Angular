/**
 *
 */
package com.cgi.springbootproject1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.springbootproject1.constants.Constants;
import com.cgi.springbootproject1.exceptions.PersonNotFoundException;
import com.cgi.springbootproject1.model.Person;
import com.cgi.springbootproject1.service.PersonService;

import io.swagger.annotations.ApiOperation;

/**
 * The Class PersonController.
 *
 * @author arun.suri
 */
@CrossOrigin("*")
@RestController
@RequestMapping
public class PersonController
{

    /** The service. */
    @Autowired
    PersonService service;

    /** The response entity. */
    ResponseEntity<?> responseEntity;

    /**
     * Post to DB.
     *
     * @param person
     *            the person
     * @return the response entity
     */
    @ApiOperation(value = Constants.API_OPERATION4)
    @PostMapping("/post/Persons")
    public ResponseEntity<?> postToDB(@RequestBody final Person person)
    {
        try
        {

            responseEntity = new ResponseEntity<>(service.postPersonChildren(person), HttpStatus.ACCEPTED);
        }
        catch (final Exception e)
        {
            responseEntity = new ResponseEntity<>(Constants.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }

    /**
     * Gets the all.
     *
     * @return the all
     */
    @ApiOperation(value = Constants.API_OPERATION5)
    @GetMapping("/get/Persons")
    public ResponseEntity<?> getAll()
    {
        List<Person> list;
        try
        {
            list = service.getAllPersons();
            return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
        }
        catch (final PersonNotFoundException e)
        {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * Find by id.
     *
     * @param id
     *            the id
     * @return the response entity
     */
    @ApiOperation(value = Constants.API_OPERATION7)
    @GetMapping("/get/Personby/{parentId}")
    public ResponseEntity<?> findByParentId(@PathVariable final int parentId)
    {

        final List<Person> list = service.findByParentId(parentId);
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    /**
     * Find by id.
     *
     * @param id
     *            the id
     * @return the response entity
     */
    @ApiOperation(value = Constants.API_OPERATION6)
    @GetMapping("/get/Person/{id}")
    public ResponseEntity<?> findById(@PathVariable final int id)
    {

        final List<Person> list = service.findByID(id);
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

}

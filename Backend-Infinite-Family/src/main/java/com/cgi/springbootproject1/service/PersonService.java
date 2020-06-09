/**
 *
 */
package com.cgi.springbootproject1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cgi.springbootproject1.exceptions.PersonNotFoundException;
import com.cgi.springbootproject1.model.Person;

/**
 * The Interface PersonService.
 *
 * @author arun.suri
 */
@Service
public interface PersonService
{

    /**
     * Post person children.
     *
     * @param Person
     *            the person
     * @return the person
     */
    public Person postPersonChildren(final Person Person);

    /**
     * Gets the all persons.
     *
     * @return the all persons
     */
    public List<Person> getAllPersons() throws PersonNotFoundException;

    /**
     * Find by id.
     *
     * @param id
     *            the id
     * @return the optional
     */
    public List<Person> findByParentId(final int id);

    /**
     * Find by ID.
     *
     * @param id
     *            the id
     * @return the list
     */
    public List<Person> findByID(final int id);
}

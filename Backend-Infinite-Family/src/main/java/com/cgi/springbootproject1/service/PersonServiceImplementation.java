/**
 *
 */
package com.cgi.springbootproject1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.springbootproject1.constants.Constants;
import com.cgi.springbootproject1.exceptions.PersonNotFoundException;
import com.cgi.springbootproject1.model.Person;
import com.cgi.springbootproject1.repository.PersonRepository;

/**
 * The Class PersonServiceImplementation.
 *
 * @author arun.suri
 */
@Service
public class PersonServiceImplementation implements PersonService
{

    /** The person repository. */
    @Autowired
    PersonRepository personRepository;

    /**
     * Post person children.
     *
     * @param person
     *            the person
     * @return the person
     */
    @Override
    public Person postPersonChildren(final Person person)
    {

        final Person persons = personRepository.save(person);

        return persons;
    }

    /**
     * Gets the all persons.
     *
     * @return the all persons
     */
    @Override
    public List<Person> getAllPersons() throws PersonNotFoundException
    {
        final List<Person> list = personRepository.findAll();
        final List<Person> personList = new ArrayList<>();
        for (final Person person : list)
        {
            if (person.getParentId() == 0)
            {
                createChildren(person, list);
                personList.add(person);
            }
        }
        if (list.isEmpty())
        {
            throw new PersonNotFoundException(Constants.EMPTY_LIST);
        }
        return personList;

    }

    /**
     * Find by id.
     *
     * @param id
     *            the id
     * @return the optional
     */
    @Override
    public List<Person> findByParentId(final int id)
    {
        final List<Person> list = personRepository.findAll();
        final List<Person> personList = new ArrayList<>();

        for (final Person person : list)
        {
            if (person.getParentId() == id)
            {
                createChildren(person, list);
                personList.add(person);
            }
        }
        return personList;

    }

    /**
     * Find by ID.
     *
     * @param id
     *            the id
     * @return the list
     */
    @Override
    public List<Person> findByID(final int id)
    {
        final List<Person> list = personRepository.findAll();
        final List<Person> personList = new ArrayList<>();

        for (final Person person : list)
        {
            if (person.getId() == id)
            {
                createChildren(person, list);
                personList.add(person);
            }
        }
        return personList;

    }

    /**
     * Creates the children.
     *
     * @param p
     *            the p
     * @param list
     *            the list
     */
    public void createChildren(final Person p, final List<Person> list)
    {
        for (final Person person : list)
        {
            if (person.getParentId() == p.getId())
            {
                createChildren(person, list);
                p.addChildren(person);
            }
        }
    }

}

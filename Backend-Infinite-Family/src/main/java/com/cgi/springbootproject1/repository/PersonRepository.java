/**
 *
 */
package com.cgi.springbootproject1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.cgi.springbootproject1.model.Person;

/**
 * The Interface PersonRepository.
 *
 * @author arun.suri
 */
public interface PersonRepository extends JpaRepository<Person, Integer>
{

    List<Person> findByParentId(@Param("id") int id);
}

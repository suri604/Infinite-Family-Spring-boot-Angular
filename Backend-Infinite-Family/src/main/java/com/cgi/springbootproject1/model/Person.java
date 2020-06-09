/**
 *
 */
package com.cgi.springbootproject1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Person.
 *
 * @author arun.suri
 */
@Entity
@Table(name = "Family1")
public class Person
{

    /** The id. */
    @Id
    @Column(name = "ID_")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /** The age. */
    @Column(name = "AGE_")
    private int age;

    /** The name. */
    @Column(name = "NAME_")
    private String name;

    @Column(name = "PARENT_ID")
    private int parentId;

    /** The children. */
    @Column(name = "CHILDREN_")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Person> children;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @return the children
     */
    public List<Person> getChildren()
    {
        return children;
    }

    /**
     * @param children
     *            the children to set
     */
    public void setChildren(final List<Person> children)
    {
        this.children = children;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the id to set
     */
    public void setId(final int id)
    {
        this.id = id;
    }

    /**
     * Gets the age.
     *
     * @return the age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Sets the age.
     *
     * @param age
     *            the age to set
     */
    public void setAge(final int age)
    {
        this.age = age;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the name to set
     */
    public void setName(final String name)
    {
        this.name = name;
    }

    /**
     * Sets the children.
     *
     * @param children
     *            the children to set
     */
    public void addChildren(final Person p)
    {
        if (children == null)
        {
            children = new ArrayList<>();
        }
        children.add(p);
    }

    /**
     * @return the parentId
     */
    public int getParentId()
    {
        return parentId;
    }

    /**
     * @param parentId
     *            the parentId to set
     */
    public void setParentId(final int parentId)
    {
        this.parentId = parentId;
    }

    /**
     * Instantiates a new person.
     */
    public Person()
    {

    }

}

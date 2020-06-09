/**
 *
 */
package com.cgi.springbootproject1.exceptions;

/**
 * The Class PersonNotFoundException.
 *
 * @author arun.suri
 */
public class PersonNotFoundException extends Exception
{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The message. */
    String message;

    /**
     * Instantiates a new person not found exception.
     *
     * @param message
     *            the message
     */
    public PersonNotFoundException(final String message)
    {

        this.message = message;
    }

    /**
     * Instantiates a new person not found exception.
     */
    public PersonNotFoundException()
    {

    }

}

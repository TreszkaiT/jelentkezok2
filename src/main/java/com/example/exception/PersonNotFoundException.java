package com.example.exception;

/**
 * Saját hibaüzenet
 *
 *
 *
 */
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String message) {
        super(message);
    }
}

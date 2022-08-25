package com.example.exception;

import java.util.List;

/**
 * a ContorllerAdvice Validation hibáit kapja el a Controller-en keresztül
 */
public class InvalidPersonException extends RuntimeException {

    private List<String> message;

    public InvalidPersonException(String message, List<String> messages) {           // egy hibaüzenetet és egy messages listát adunk meg, hogy mi volt a hiba
        super(message);
        this.message = messages;
    }

    // hogy a personContorllerAdvice-ben lekérhessem az exception.getmessages()-t
   /* @Override
    public List<String> getMessage() {//<String> getMessage() {
        return this.message;
    }*/
}
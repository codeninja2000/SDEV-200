package com.m06.p01_staffrecord;

/**
 * DatabaseException is a custom exception class that extends RuntimeException.
 * It is used to indicate errors related to database operations.
 */
public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}

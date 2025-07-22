package com.m06.p01_staffrecord;

/**
 * StaffNotFoundException is a custom exception thrown when a staff member
 * cannot be found in the database.
 * It extends the Exception class and provides constructors for different use cases.
 */
public class StaffNotFoundException extends Exception{
    public StaffNotFoundException(String message) {
        super(message);
    }

    public StaffNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StaffNotFoundException(Throwable cause) {
        super(cause);
    }
}

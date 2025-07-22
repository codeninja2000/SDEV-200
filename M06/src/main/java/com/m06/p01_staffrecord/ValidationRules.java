package com.m06.p01_staffrecord;

/**
 * ValidationRules is a utility class that provides validation rules for various fields
 * in the staff record application. It defines constants for field lengths and provides
 * methods to validate field lengths and maximum lengths.
 */
public class ValidationRules {
    private static final int ID_LENGTH = 9;
    private static final int MAX_NAME_LENGTH = 15;
    private static final int MAX_ADDRESS_LENGTH = 20;
    private static final int MAX_CITY_LENGTH = 20;
    private static final int STATE_LENGTH = 2;
    private static final int PHONE_LENGTH = 10;
    private static final int MAX_EMAIL_LENGTH = 40;

    private ValidationRules() {}

    // Public getters for the constants
    public static int getIdLength() { return ID_LENGTH; }
    public static int getMaxNameLength() { return MAX_NAME_LENGTH; }
    public static int getMaxAddressLength() { return MAX_ADDRESS_LENGTH; }
    public static int getMaxCityLength() { return MAX_CITY_LENGTH; }
    public static int getStateLength() { return STATE_LENGTH; }
    public static int getPhoneLength() { return PHONE_LENGTH; }
    public static int getMaxEmailLength() { return MAX_EMAIL_LENGTH; }


    /**
     * Validates that the given value is not null and has the exact length specified.
     *
     * @param value the string value to validate
     * @param exactLength the exact length that the value must have
     * @param fieldName the name of the field for error reporting
     * @throws IllegalArgumentException if the value is not null and does not match the exact length
     */
    public static void validateField(String value, int exactLength, String fieldName) {
        if (value != null && value.length() != exactLength) {
            throw new IllegalArgumentException(fieldName + " must be exactly " + exactLength + " characters long");
        }
    }

    /**
     * Validates that the given value is not null and does not exceed the maximum length specified.
     *
     * @param value the string value to validate
     * @param maxLength the maximum length that the value can have
     * @param fieldName the name of the field for error reporting
     * @throws IllegalArgumentException if the value is not null and exceeds the maximum length
     */
    public static void validateMaxLength(String value, int maxLength, String fieldName) {
        if (value != null && value.length() > maxLength) {
            throw new IllegalArgumentException(fieldName + " cannot exceed " + maxLength + " characters");
        }
    }
}
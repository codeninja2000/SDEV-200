package com.m06.p01_staffrecord;

/**
 * Staff class represents a staff member with various attributes.
 * It includes validation for each field to ensure data integrity.
 */
public class Staff {
    private String id;          // char(9)
    private String lastName;    // varchar(15)
    private String firstName;   // varchar(15)
    private String mi;         // char
    private String address;    // varchar(20)
    private String city;       // varchar(20)
    private String state;      // char(2)
    private String telephone;  // char(10)
    private String email;      // varchar(40)

    // Default constructor
    public Staff() {}

    // Constructor with all fields
    public Staff(String id, String lastName, String firstName, String mi,
                 String address, String city, String state, String telephone, String email) {
        // Validate all fields
        ValidationRules.validateField(id, ValidationRules.getIdLength(), "ID");
        ValidationRules.validateMaxLength(lastName, ValidationRules.getMaxNameLength(), "Last name");
        ValidationRules.validateMaxLength(firstName, ValidationRules.getMaxNameLength(), "First name");
        ValidationRules.validateField(mi, 1, "Middle initial");
        ValidationRules.validateMaxLength(address, ValidationRules.getMaxAddressLength(), "Address");
        ValidationRules.validateMaxLength(city, ValidationRules.getMaxCityLength(), "City");
        ValidationRules.validateField(state, ValidationRules.getStateLength(), "State");
        ValidationRules.validateField(telephone, ValidationRules.getPhoneLength(), "Telephone");
        ValidationRules.validateMaxLength(email, ValidationRules.getMaxEmailLength(), "Email");
        
        // Set fields after validation
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mi = mi;
        this.address = address;
        this.city = city;
        this.state = state;
        this.telephone = telephone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
       ValidationRules.validateField(id, ValidationRules.getIdLength(), "ID");
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        ValidationRules.validateMaxLength(lastName, ValidationRules.getMaxNameLength(), "Last name");
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        ValidationRules.validateMaxLength(firstName, ValidationRules.getMaxNameLength(), "First name");
        this.firstName = firstName;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        if (mi != null && mi.length() > 1) {
            throw new IllegalArgumentException("Middle initial must be a single character");
        }
        this.mi = mi;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        ValidationRules.validateMaxLength(address, ValidationRules.getMaxAddressLength(), "Address");
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
       ValidationRules.validateMaxLength(city, ValidationRules.getMaxCityLength(), "City");
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
       ValidationRules.validateField(state, ValidationRules.getStateLength(), "State");
        this.state = state;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        ValidationRules.validateField(telephone, ValidationRules.getPhoneLength(), "Telephone");
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        ValidationRules.validateMaxLength(email, ValidationRules.getMaxEmailLength(), "Email");
        this.email = email;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", mi='" + mi + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
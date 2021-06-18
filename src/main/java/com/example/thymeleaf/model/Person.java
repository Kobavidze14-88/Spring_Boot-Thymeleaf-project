package com.example.thymeleaf.model;

public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String dateOfBirth;
    private String placeOfResidence;
    private String number;
    private String position;

    public Person() {
    }

    public Person(String firstName, String lastName, String middleName,String email, String dateOfBirth, String placeOfResidence, String number, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.placeOfResidence = placeOfResidence;
        this.number = number;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public String getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }
}
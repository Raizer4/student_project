package studentOrder.domain;

import java.time.LocalDate;

public abstract class Person {

    private String givenName;
    private String surName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Address address;

    public Person() {
    }

    public Person(String givenName, String surName, String patronymic, LocalDate dateOfBirth, Address address) {
        this.givenName = givenName;
        this.surName = surName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }



    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



}

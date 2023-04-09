package org.example.models;

import org.example.enums.Gender;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    private Gender gender;
    private String birthDate;
    private String birthPlace;

    public Person(String firstName, String lastName, String middleName, int age, Gender gender, String birthDate, String birthPlace) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
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

    public Gender getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                '}';
    }

    public String getAgeAsString() {
        return String.valueOf(age);
    }
}


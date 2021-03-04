package com.github.crud.models;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private static final long serialVersionUID = 5703010892441581683L;

    private long personId;

    private String firstName;

    private String lastName;

    private int age;

    private String city;

    public Person() {
    }

    public Person(long personId, String firstName, String lastName, int age, String city) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public long getId() {
        return personId;
    }

    public void setId(long newId) {
        personId = newId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String newCity) {
        city = newCity;
    }

    @Override
    public String toString() {
        return "id - " + personId + "\n" + "firstname - " + firstName + "\n" + "lastname - " + lastName + "\n" + "age - " + age + "\n" + "city - " + city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, firstName, lastName, age, city);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Person guest = (Person) obj;
        return personId == guest.personId
                && (firstName.equals(guest.firstName))
                && (lastName.equals(guest.lastName))
                && (age == guest.age)
                && (city.equals(guest.city));
    }
}

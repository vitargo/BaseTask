package com.github.gui.crud.entity;

import com.github.gui.crud.utils.people.PersonColumn;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private static final long serialVersionUID = 3209363645813174245L;

    @PersonColumn(name = "ID")
    private long id;

    @PersonColumn(name = "First Name")
    private String firstName;

    @PersonColumn(name = "Last Name")
    private String lastName;

    @PersonColumn(name = "Age")
    private int age;

    @PersonColumn(name = "City")
    private String city;

    public Person() {
    }

    public Person(String firstName, String lastName, int age, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public Person(long id, String firstName, String lastName, int age, String city) {
        this(firstName, lastName, age, city);
        this.id = id;
    }

    private Person(Builder b) {
        this.id = b.id;
        this.firstName = b.firstName;
        this.lastName = b.lastName;
        this.age = b.age;
        this.city = b.city;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person id(long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, city);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    public static class Builder {

        private long id;

        private String firstName;

        private String lastName;

        private int age;

        private String city;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String  lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

}

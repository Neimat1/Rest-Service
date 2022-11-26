package org.example.model;

public class Customer {
    private String firstName;
    private String lastName;
    private int age;
    public Customer(){}
    public Customer(String firstName, String lastName, int age, String nationalID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationalID = nationalID;
    }

    private String nationalID;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }
}

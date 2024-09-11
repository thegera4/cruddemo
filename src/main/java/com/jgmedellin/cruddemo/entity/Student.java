package com.jgmedellin.cruddemo.entity;

import jakarta.persistence.*;

@Entity // This annotation is used to indicate that the class is an entity (a table in the database)
@Table(name="student")  // This annotation is used to indicate the name of the table in the database
public class Student {

    // define fields (columns in the table)
    @Id // This annotation is used to indicate that the field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Annotation used to indicate the field is auto-generated.
    @Column(name="id") // This annotation is used to indicate the name of the column in the table
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    // define constructors
    public Student() {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // define toString method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

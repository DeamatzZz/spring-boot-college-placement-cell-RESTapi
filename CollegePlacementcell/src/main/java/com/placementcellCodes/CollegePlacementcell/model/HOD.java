package com.placementcellCodes.CollegePlacementcell.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hods") // MongoDB collection name
public class HOD {

    @Id // This annotation marks the field as the primary key
    private String id;
    
    private String name;
    private String department;
    private String email;
    private String phoneNumber;
    private String password; // For authentication

    // Default constructor
    public HOD() {}

    // Parameterized constructor
    public HOD(String name, String department, String email, String phoneNumber, String password) {
        this.name = name;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method for easy debugging
    @Override
    public String toString() {
        return "HOD{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

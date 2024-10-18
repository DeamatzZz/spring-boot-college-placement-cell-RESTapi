package com.placementcellCodes.CollegePlacementcell.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students") // Specifies the MongoDB collection
public class Student {
    @Id // Marks the id field as the primary key
    private String id;
    private String name;
    private String email;
    private String status; // e.g., "Applied", "Accepted", etc.

    // Constructors
    public Student() {}

    public Student(String name, String email, String status) {
        this.name = name;
        this.email = email;
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

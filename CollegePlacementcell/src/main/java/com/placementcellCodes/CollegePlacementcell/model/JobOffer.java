package com.placementcellCodes.CollegePlacementcell.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "job_offers") // Specifies the MongoDB collection
public class JobOffer {
    @Id
    private String id;
    private String companyName;
    private String position;
    private String eligibility; // e.g., "B.Tech", "MBA", etc.
    private String description; // Job description

    // Constructors
    public JobOffer() {}

    public JobOffer(String companyName, String position, String eligibility, String description) {
        this.companyName = companyName;
        this.position = position;
        this.eligibility = eligibility;
        this.description = description;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

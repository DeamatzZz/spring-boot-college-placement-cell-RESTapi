package com.placementcellCodes.CollegePlacementcell.repository;

import  com.placementcellCodes.CollegePlacementcell.model.JobOffer;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobOfferRepository extends MongoRepository<JobOffer, String> {
    // Example: Find job offers by company name
    List <JobOffer> findByCompanyName(String companyName);

	List<JobOffer> findAll();
}

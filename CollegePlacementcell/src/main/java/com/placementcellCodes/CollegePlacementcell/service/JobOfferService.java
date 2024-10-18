package com.placementcellCodes.CollegePlacementcell.service;



import com.placementcellCodes.CollegePlacementcell.model.JobOffer;
import com.placementcellCodes.CollegePlacementcell.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indicates that this class is a Spring service
public class JobOfferService {
    private final JobOfferRepository jobOfferRepository;

    @Autowired // Spring will automatically inject the JobOfferRepository bean
    public JobOfferService(JobOfferRepository jobOfferRepository) {
        this.jobOfferRepository = jobOfferRepository;
    }

    // Method to fetch all job offers
    public List<JobOffer> getAllJobOffers() {
        return jobOfferRepository.findAll(); // Calls the repository method
    }

    // Method to find job offers by company name
    public List<JobOffer> getJobOffersByCompany(String companyName) {
        return jobOfferRepository.findByCompanyName(companyName); // Calls the custom query method
    }

    // Method to save a new job offer
    public void addJobOffer(JobOffer jobOffer) {
        jobOfferRepository.save(jobOffer); // Calls the repository method to save the entity
    }

    // Other business logic methods can be added here
}

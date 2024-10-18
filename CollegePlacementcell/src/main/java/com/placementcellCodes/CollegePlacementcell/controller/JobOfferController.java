package com.placementcellCodes.CollegePlacementcell.controller;



import com.placementcellCodes.CollegePlacementcell.model.JobOffer;
import com.placementcellCodes.CollegePlacementcell.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indicates that this class is a REST controller
@RequestMapping("/api/jobOffers") // Base URL for job offers
public class JobOfferController {
    private final JobOfferService jobOfferService;

    @Autowired // Inject the JobOfferService
    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @GetMapping // Endpoint to get all job offers
    public List<JobOffer> getAllJobOffers() {
        return jobOfferService.getAllJobOffers(); // Calls the service method
    }

    @GetMapping("/company/{companyName}") // Endpoint to get job offers by company
    public List<JobOffer> getJobOffersByCompany(@PathVariable String companyName) {
        return jobOfferService.getJobOffersByCompany(companyName); // Calls the service method
    }

    @PostMapping // Endpoint to add a new job offer
    public void addJobOffer(@RequestBody JobOffer jobOffer) {
        jobOfferService.addJobOffer(jobOffer); // Calls the service method
    }

    // Additional endpoints can be added here
}


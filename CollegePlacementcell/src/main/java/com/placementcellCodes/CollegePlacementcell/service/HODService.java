package com.placementcellCodes.CollegePlacementcell.service;



import com.placementcellCodes.CollegePlacementcell.model.HOD;
import com.placementcellCodes.CollegePlacementcell.repository.HODRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HODService {

    private final HODRepository hodRepository;

    @Autowired
    public HODService(HODRepository hodRepository) {
        this.hodRepository = hodRepository;
    }

    // Method to fetch all HODs
    public List<HOD> getAllHODs() {
        return hodRepository.findAll();
    }

    // Method to fetch HOD by ID
    public Optional<HOD> getHODById(String id) {
        return hodRepository.findById(id);
    }

    // Method to fetch HOD by email (for login or identification purposes)
    public Optional<HOD> getHODByEmail(String email) {
        return hodRepository.findByEmail(email);
    }

    // Method to add a new HOD
    public HOD addHOD(HOD hod) {
        return hodRepository.save(hod);
    }

    // Method to update an existing HOD
    public HOD updateHOD(String id, HOD hod) {
        if (hodRepository.existsById(id)) {
            hod.setId(id); // Ensure the ID matches the existing record
            return hodRepository.save(hod);
        }
        return null;
    }

    // Method to delete an HOD by ID
    public void deleteHOD(String id) {
        hodRepository.deleteById(id);
    }
}
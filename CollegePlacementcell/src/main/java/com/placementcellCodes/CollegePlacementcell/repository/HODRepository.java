package com.placementcellCodes.CollegePlacementcell.repository;



import com.placementcellCodes.CollegePlacementcell.model.HOD;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HODRepository extends MongoRepository<HOD, String> {
    // Custom query to find HOD by email (for login or search purposes)
    Optional<HOD> findByEmail(String email);
}

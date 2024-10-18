package com.placementcellCodes.CollegePlacementcell.service;


import com.placementcellCodes.CollegePlacementcell.model.Admin;
import com.placementcellCodes.CollegePlacementcell.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indicates that this class is a service layer component
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired // Spring will automatically inject the AdminRepository bean
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Method to fetch all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll(); // Calls the repository method to get all admins
    }

    // Method to fetch an admin by ID
    public Optional<Admin> getAdminById(String id) {
        return adminRepository.findById(id); // Calls the repository method to find an admin by ID
    }

    // Method to fetch an admin by username
    public Optional<Admin> getAdminByUsername(String username) {
        return Optional.ofNullable(adminRepository.findByUsername(username)); // Calls the custom query method
    }

    // Method to add a new admin
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin); // Calls the repository method to save the admin
    }

    // Method to update an existing admin
    public Admin updateAdmin(String id, Admin admin) {
        // Check if the admin exists
        if (adminRepository.existsById(id)) {
            admin.setId(id); // Set the ID to the existing admin
            return adminRepository.save(admin); // Update the admin
        }
        return null; // Return null if the admin does not exist
    }

    // Method to delete an admin by ID
    public void deleteAdmin(String id) {
        adminRepository.deleteById(id); // Calls the repository method to delete an admin by ID
    }

    // Additional methods can be added as needed
}

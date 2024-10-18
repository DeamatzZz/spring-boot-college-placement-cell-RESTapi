package com.placementcellCodes.CollegePlacementcell.controller;



import com.placementcellCodes.CollegePlacementcell.model.Admin;
import com.placementcellCodes.CollegePlacementcell.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Indicates that this class handles HTTP requests
@RequestMapping("/api/admins") // Base URL for admin-related endpoints
public class AdminController {

    private final AdminService adminService;

    @Autowired // Spring will automatically inject the AdminService bean
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping // Endpoint to get all admins
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins(); // Calls the service method
    }

    @GetMapping("/{id}") // Endpoint to get an admin by ID
    public ResponseEntity<Admin> getAdminById(@PathVariable String id) {
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/username/{username}") // Endpoint to get an admin by username
    public ResponseEntity<Admin> getAdminByUsername(@PathVariable String username) {
        Optional<Admin> admin = adminService.getAdminByUsername(username);
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping // Endpoint to add a new admin
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin); // Calls the service method
    }

    @PutMapping("/{id}") // Endpoint to update an existing admin
    public ResponseEntity<Admin> updateAdmin(@PathVariable String id, @RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdmin(id, admin);
        return updatedAdmin != null ? ResponseEntity.ok(updatedAdmin) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}") // Endpoint to delete an admin by ID
    public ResponseEntity<Void> deleteAdmin(@PathVariable String id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build(); // Returns 204 No Content
    }
}

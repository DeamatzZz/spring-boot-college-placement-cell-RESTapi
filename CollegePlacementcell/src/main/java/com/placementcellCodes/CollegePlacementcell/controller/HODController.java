package com.placementcellCodes.CollegePlacementcell.controller;


import com.placementcellCodes.CollegePlacementcell.model.HOD;
import com.placementcellCodes.CollegePlacementcell.service.HODService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hods") // Base URL for HOD endpoints
public class HODController {

    private final HODService hodService;

    @Autowired
    public HODController(HODService hodService) {
        this.hodService = hodService;
    }

    // Endpoint to get all HODs
    @GetMapping
    public List<HOD> getAllHODs() {
        return hodService.getAllHODs();
    }

    // Endpoint to get HOD by ID
    @GetMapping("/{id}")
    public ResponseEntity<HOD> getHODById(@PathVariable String id) {
        Optional<HOD> hod = hodService.getHODById(id);
        return hod.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to get HOD by email (for login/verification)
    @GetMapping("/email/{email}")
    public ResponseEntity<HOD> getHODByEmail(@PathVariable String email) {
        Optional<HOD> hod = hodService.getHODByEmail(email);
        return hod.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to add a new HOD
    @PostMapping
    public HOD addHOD(@RequestBody HOD hod) {
        return hodService.addHOD(hod);
    }

    // Endpoint to update an existing HOD
    @PutMapping("/{id}")
    public ResponseEntity<HOD> updateHOD(@PathVariable String id, @RequestBody HOD hod) {
        HOD updatedHOD = hodService.updateHOD(id, hod);
        return updatedHOD != null ? ResponseEntity.ok(updatedHOD) : ResponseEntity.notFound().build();
    }

    // Endpoint to delete an HOD by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHOD(@PathVariable String id) {
        hodService.deleteHOD(id);
        return ResponseEntity.noContent().build(); // Returns HTTP 204 No Content
    }
}

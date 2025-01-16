package com.student.controller;

import com.student.model.ScholarHosteller;
import com.student.service.ScholarHostellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scholar-hosteller")
public class ScholarHostellerController {

    @Autowired
    private ScholarHostellerService scholarHostellerService;

    // Endpoint to create or update Scholar/Hosteller info
    @PostMapping
    public ResponseEntity<String> createScholarHostellerInfo(@RequestBody ScholarHosteller scholarHosteller) {
        scholarHostellerService.saveScholarHostellerInfo(scholarHosteller);
        return ResponseEntity.ok("Scholar/Hosteller info saved successfully.");
    }

    // Endpoint to get Scholar/Hosteller info by ID
    @GetMapping("/{id}")
    public ResponseEntity<ScholarHosteller> getScholarHostellerInfoById(@PathVariable Integer id) {
        ScholarHosteller scholarHosteller = scholarHostellerService.getScholarHostellerInfoById(id);
        if (scholarHosteller != null) {
            return ResponseEntity.ok(scholarHosteller);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

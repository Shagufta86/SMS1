package com.student.controller;

import com.student.model.Transportation;
import com.student.service.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transportation")
public class TransportationController {

    @Autowired
    private TransportationService transportationService;

    // Endpoint to create or update transportation info
    @PostMapping
    public ResponseEntity<String> createTransportationInfo(@RequestBody Transportation transportation) {
        transportationService.saveTransportationInfo(transportation);
        return ResponseEntity.ok("Transportation info saved successfully.");
    }

    // Endpoint to get transportation info by ID
    @GetMapping("/{id}")
    public ResponseEntity<Transportation> getTransportationInfoById(@PathVariable Integer id) {
        Transportation transportation = transportationService.getTransportationInfoById(id);
        if (transportation != null) {
            return ResponseEntity.ok(transportation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

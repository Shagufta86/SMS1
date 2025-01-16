package com.student.controller;

import com.student.service.EnrollmentTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollment-tracker")
public class EnrollmentTrackerController {

    @Autowired
    private EnrollmentTrackerService enrollmentTrackerService;

    // Endpoint to get the last enrollment number for a given course code and year
    @GetMapping("/{courseCode}/{yearJoined}")
    public ResponseEntity<Integer> getLastEnrollmentNumber(@PathVariable String courseCode, @PathVariable Integer yearJoined, @PathVariable String accommodationType) {
        Integer lastEnrollmentNumber = enrollmentTrackerService.getLastEnrollmentNumber(courseCode, yearJoined, accommodationType);
        return ResponseEntity.ok(lastEnrollmentNumber);
    }

    // Endpoint to update the last enrollment number for a given course code and year
    @PostMapping("/update")
    public ResponseEntity<String> updateLastEnrollmentNumber(@RequestParam String courseCode, @RequestParam Integer yearJoined, @RequestParam String accommodationType, @RequestParam Integer lastEnrollmentNumber) {
        enrollmentTrackerService.updateLastEnrollmentNumber(courseCode, yearJoined, accommodationType, lastEnrollmentNumber);
        return ResponseEntity.ok("Enrollment tracker updated successfully.");
    }
}

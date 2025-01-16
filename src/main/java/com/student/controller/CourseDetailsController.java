package com.student.controller;

import com.student.model.CourseDetails;
import com.student.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseDetailsController {

    @Autowired
    private CourseDetailsService courseDetailsService;

    // Endpoint to register course details
    @PostMapping("/register")
    public ResponseEntity<String> registerCourseDetails(@RequestBody CourseDetails courseDetails) {
        courseDetailsService.saveCourseDetails(courseDetails);
        return ResponseEntity.ok("Course details saved successfully for enrollment number: " + courseDetails.getEnrollmentNumber());
    }

    // Endpoint to retrieve course details by enrollment number
    @GetMapping("/{enrollmentNumber}")
    public ResponseEntity<CourseDetails> getCourseDetails(@PathVariable String enrollmentNumber) {
        CourseDetails courseDetails = courseDetailsService.getCourseDetailsByEnrollmentNumber(enrollmentNumber);
        if (courseDetails != null) {
            return ResponseEntity.ok(courseDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

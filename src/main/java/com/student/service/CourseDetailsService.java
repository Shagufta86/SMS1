package com.student.service;

import com.student.model.CourseDetails;
import com.student.repository.CourseDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseDetailsService {

    @Autowired
    private CourseDetailsRepository courseDetailsRepository;

    public void saveCourseDetails(CourseDetails courseDetails) {
        // Save course details to the database
        courseDetailsRepository.save(courseDetails);
    }

    public CourseDetails getCourseDetailsByEnrollmentNumber(String enrollmentNumber) {
        // Find course details by enrollment number
        return courseDetailsRepository.findByEnrollmentNumber(enrollmentNumber);
    }

}

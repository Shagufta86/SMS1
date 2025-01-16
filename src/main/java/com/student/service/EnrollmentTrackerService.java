package com.student.service;

import com.student.model.EnrollmentTracker;
import com.student.repository.EnrollmentTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentTrackerService {

    @Autowired
    private EnrollmentTrackerRepository enrollmentTrackerRepository;

    // Get the last enrollment number for a given course code and year
    public Integer getLastEnrollmentNumber(String courseCode, Integer yearJoined, String accommodationType) {
        EnrollmentTracker tracker = enrollmentTrackerRepository.findByCourseCodeAndYearJoinedAndAccommodationType(courseCode, yearJoined, accommodationType);
        if (tracker != null) {
            return tracker.getLastEnrollmentNumber();
        }
        return 0; // Default value if no tracker exists
    }

    // Update the last enrollment number for a given course code and year
    public void updateLastEnrollmentNumber(String courseCode, Integer yearJoined, String accommodationType,Integer lastEnrollmentNumber) {
        EnrollmentTracker tracker = enrollmentTrackerRepository.findByCourseCodeAndYearJoinedAndAccommodationType(courseCode, yearJoined, accommodationType) ;
        if (tracker != null) {
            tracker.setLastEnrollmentNumber(lastEnrollmentNumber);
            enrollmentTrackerRepository.save(tracker);
        } else {
            // If no tracker exists, create a new one
            EnrollmentTracker newTracker = new EnrollmentTracker();
            newTracker.setCourseCode(courseCode);
            newTracker.setYearJoined(yearJoined);
            newTracker.setAccommodationType(accommodationType); // Set the accommodation type

            newTracker.setLastEnrollmentNumber(lastEnrollmentNumber);
            enrollmentTrackerRepository.save(newTracker);
        }
    }
}


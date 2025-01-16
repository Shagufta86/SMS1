package com.student.repository;

import com.student.model.EnrollmentTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentTrackerRepository extends JpaRepository<EnrollmentTracker, Integer> {
    // Custom query to find tracker by course code and year joined
    EnrollmentTracker findByCourseCodeAndYearJoinedAndAccommodationType(String courseCode, Integer yearJoined, String accommodationType);
}

package com.student.repository;

import com.student.model.CourseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDetailsRepository extends JpaRepository<CourseDetails, Integer> {
    // You can add custom queries here if needed
    CourseDetails findByEnrollmentNumber(String enrollmentNumber);
}

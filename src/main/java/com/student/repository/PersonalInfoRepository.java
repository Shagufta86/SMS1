package com.student.repository;

import com.student.model.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Integer> {
    // Get the next available registration number for a given course code and year
    @Query("SELECT COALESCE(MAX(r.id), 0) + 1 FROM PersonalInfo r " +
            "WHERE r.courseCode = :courseCode " +
            "AND r.yearJoined = :yearJoined " +
            "AND r.accommodationType = :accommodationType")
    long getNextRegistrationNumber(@Param("courseCode") String courseCode,
                                   @Param("yearJoined") int yearJoined,
                                   @Param("accommodationType") String accommodationType);
}
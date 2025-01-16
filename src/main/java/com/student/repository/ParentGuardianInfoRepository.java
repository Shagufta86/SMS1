package com.student.repository;

import com.student.model.ParentGuardianInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentGuardianInfoRepository extends JpaRepository<ParentGuardianInfo, Integer> {
    // Custom queries can be added here if needed
}

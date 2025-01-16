package com.student.repository;

import com.student.model.ScholarHosteller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarHostellerRepository extends JpaRepository<ScholarHosteller, Integer> {
    // Custom queries can be added here if needed
}

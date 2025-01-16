package com.student.repository;

import com.student.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    // Custom query to find address by enrollment number if needed
    Address findByEnrollmentNumber(String enrollmentNumber);
}

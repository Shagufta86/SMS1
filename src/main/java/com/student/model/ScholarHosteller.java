package com.student.model;

import jakarta.persistence.*;

@Entity
@Table(name = "scholar_hosteller")
public class ScholarHosteller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String accommodationType;  // Hosteller or Day Scholar
    private Integer DHPayment;  // Cost of accommodation

    private String enrollmentNumber;  // Stores enrollment number

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(String accommodationType) {
        this.accommodationType = accommodationType;
    }

    public Integer getDHPayment() {
        return DHPayment;
    }

    public void setDHPayment(Integer DHPaymentCost) {
        this.DHPayment = DHPayment;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }
}

package com.student.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transportation")
public class Transportation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "transportation", nullable = false)
    private String transportation;  // Mode of transport (e.g., Bus, Train, etc.)

    @Column(name = "transport_cost", nullable = false)
    private Integer transportationPayment;  // Cost of transportation

    @Column(name = "enrollment_number", nullable = false)
    private String enrollmentNumber;  // Stores enrollment number

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public Integer getTransportationPayment() {
        return transportationPayment;
    }

    public void setTransportationPayment(Integer transportationPayment) {
        this.transportationPayment = transportationPayment;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }
}

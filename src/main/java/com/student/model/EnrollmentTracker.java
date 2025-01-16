package com.student.model;

import jakarta.persistence.*;

@Entity
public class EnrollmentTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String courseCode;  // Course code (e.g., "11", "12")
    private Integer yearJoined;  // Year student joined (e.g., 2024)
    private Integer lastEnrollmentNumber;  // Last generated enrollment number for the course
    private String accommodationType;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getYearJoined() {
        return yearJoined;
    }

    public void setYearJoined(Integer yearJoined) {
        this.yearJoined = yearJoined;
    }

    public Integer getLastEnrollmentNumber() {
        return lastEnrollmentNumber;
    }

    public String getAccomodationType() {
        return accommodationType;
    }

    public void setAccommodationType(String accommodationType) {
        this.accommodationType = accommodationType;
    }

    public void setLastEnrollmentNumber(Integer lastEnrollmentNumber) {
        this.lastEnrollmentNumber = lastEnrollmentNumber;
    }
}

package com.student.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "course_details")
public class CourseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "course", nullable = false)
    private String course;

    @NotNull
    @Column(name = "year")
    private String year;

    @Column(name = "course_code", nullable = false)
    private String courseCode;

    @Column(name = "year_joined", nullable = false)
    private Integer yearJoined;

    @Column(name = "course_fee", nullable = false)
    private Integer coursePaymentCost;

    @Column(name = "enrollment_number", nullable = false)
    private String enrollmentNumber;  // Stores enrollment number

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public Integer getCoursePaymentCost() {
        return coursePaymentCost;
    }

    public void setCoursePaymentCost(Integer coursePaymentCost) {
        this.coursePaymentCost = coursePaymentCost;
    }


    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }
}

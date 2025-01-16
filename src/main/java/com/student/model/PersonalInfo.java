package com.student.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String enrollmentNumber;

    @Column(name = "full_name", nullable = false)
    private String studentName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "aadhar_front", nullable = false)
    private String aadharFront;


    @Column(name = "aadhar_back", nullable = false)
    private String aadharB;


    @Column(name = "student_photo", nullable = false)
    private String photo;

    @Column(name = "address_line1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line2", nullable = false)
    private String addressLine2;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "pin_code", nullable = false)
    private Integer pinCode;

    @Column(name = "relation_type", nullable = false)
    private String relationType;

    @Column(name = "parent_guardian_name", nullable = false)
    private String parentGuardianName;

    @Column(name = "parent_guardian_contact", nullable = false)
    private String parentGuardianContact;

    @Column(name = "emergency_contact", nullable = false)
    private String emergencyContactNumber;

    @Column(name = "transportation", nullable = false)
    private String transportation;

    @Column(name = "transport_cost", nullable = false)
    private Integer transportationPayment;

    @Column(name = "course", nullable = false)
    private String course;

    @Column(name = "course_code", nullable = false)
    private String courseCode;

    @NotNull
    @Column(name = "year")
    private String year;

    @Column(name = "year_joined", nullable = false)
    private Integer yearJoined;

    @Column(name = "course_fee", nullable = false)
    private Integer coursePaymentCost;

    @Column(name = "accommodation_type", nullable = false)
    private String accommodationType;

    @Column(name = "DHPayment_Cost", nullable = false)
    private Integer DHPayment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public Integer getCoursePaymentCost() {
        return coursePaymentCost;
    }

    public void setCoursePaymentCost(Integer coursePaymentCost) {
        this.coursePaymentCost = coursePaymentCost;
    }

    public Integer getDHPayment() {
        return DHPayment;
    }

    public void setDHPayment(Integer DHPayment) {
        this.DHPayment = DHPayment;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAadharFront() {
        return aadharFront;
    }

    public void setAadharFront(String aadharFront) {
        this.aadharFront = aadharFront;
    }

    public String getAadharB() {
        return aadharB;
    }

    public void setAadharB(String aadharB) {
        this.aadharB = aadharB;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
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

    public String getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(String accommodationType) {
        this.accommodationType = accommodationType;
    }

    public String getParentGuardianName() {
        return parentGuardianName;
    }

    public void setParentGuardianName(String parentGuardianName) {
        this.parentGuardianName = parentGuardianName;
    }

    public String getParentGuardianContact() {
        return parentGuardianContact;
    }

    public void setParentGuardianContact(String parentGuardianContact) {
        this.parentGuardianContact = parentGuardianContact;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }


    public String getRelationType() {
        return relationType;
    }

    public PersonalInfo() {
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getCourse() {
        return course;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}

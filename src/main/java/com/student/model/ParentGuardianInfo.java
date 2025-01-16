package com.student.model;

import jakarta.persistence.*;

@Entity
@Table(name = "parent_guardian_info")
public class ParentGuardianInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "relation_type", nullable = false)
    private String relationType;

    @Column(name = "parent_guardian_name", nullable = false)
    private String parentGuardianName;

    @Column(name = "parent_guardian_contact", nullable = false)
    private String parentGuardianContact;

    @Column(name = "emergency_contact", nullable = false)
    private String emergencyContactNumber;

    @Column(name = "enrollment_number", nullable = false)
    private String enrollmentNumber;  // Stores enrollment number
    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

}

package com.student.service;

import com.student.model.Address;
import com.student.model.CourseDetails;
import com.student.model.PersonalInfo;
import com.student.repository.AddressRepository;
import com.student.repository.CourseDetailsRepository;
import com.student.repository.PersonalInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoService {

    @Autowired
    private PersonalInfoRepository personalInfoRepository;

    @Autowired
    private CourseDetailsRepository courseDetailsRepository;

    @Autowired
    private AddressRepository addressRepository;

    // Logic to generate enrollment number
    public String generateEnrollmentNumber(PersonalInfo student) {
        String courseCode = student.getCourseCode().substring(0, 2).toUpperCase(); // "CS" -> "CS"
        String yearJoined = String.valueOf(student.getYearJoined()).substring(2); // "2024" -> "24"
        long registrationNumber = personalInfoRepository.getNextRegistrationNumber(courseCode, student.getYearJoined(), student.getAccommodationType());
        String formattedRegistrationNumber = String.format("%06d", registrationNumber);
        String accommodationType = student.getAccommodationType(); // Assuming the field is "Hosteller" or "Day Scholar"
        String accommodationFlag = (accommodationType.equalsIgnoreCase("Hosteller")) ? "1" : "0";
        return courseCode + yearJoined + formattedRegistrationNumber + accommodationFlag;
    }

    @Transactional
    public void saveStudent(PersonalInfo student) {
        // Generate enrollment number first before saving the student
        String enrollmentNumber = generateEnrollmentNumber(student);

        // Set the generated enrollment number to the student entity
        student.setEnrollmentNumber(enrollmentNumber);

        // Validate that enrollmentNumber is not null or empty
        if (student.getEnrollmentNumber() == null || student.getEnrollmentNumber().isEmpty()) {
            throw new IllegalArgumentException("Enrollment Number is required.");
        }

        // Save the PersonalInfo entity with the enrollment number
        personalInfoRepository.save(student);

        // Get the generated ID from the saved entity
        Integer personalInfoId = student.getId();

        // Save CourseDetails with the generated enrollment number
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setCourse(student.getCourse());
        courseDetails.setYear(student.getYear());
        courseDetails.setCourseCode(student.getCourseCode());
        courseDetails.setYearJoined(student.getYearJoined());
        courseDetails.setCoursePaymentCost(student.getCoursePaymentCost());
        courseDetails.setEnrollmentNumber(enrollmentNumber);
        courseDetailsRepository.save(courseDetails);

        // Save Address, now that PersonalInfo has been saved and the ID is available
        Address address = new Address();
        address.setAddressLine1(student.getAddressLine1());
        address.setAddressLine2(student.getAddressLine2());
        address.setCountry(student.getCountry());
        address.setState(student.getState());
        address.setDistrict(student.getDistrict());
        address.setPinCode(student.getPinCode());
        address.setEnrollmentNumber(enrollmentNumber);
        addressRepository.save(address);
    }
}

package com.student.controller;

import com.student.model.PersonalInfo;
import com.student.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.util.HashMap;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PersonalInfoController {

    @Autowired
    private PersonalInfoService personalInfoService;

    private static final String BASE_DIRECTORY =  System.getProperty("user.home") + "/Downloads/uploads/";

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(
            @RequestParam("studentName") String studentName,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("aadharFront") MultipartFile aadharFront,
            @RequestParam("aadharB") MultipartFile aadharB,
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("addressLine1") String addressLine1,
            @RequestParam("addressLine2") String addressLine2,
            @RequestParam("country") String country,
            @RequestParam("state") String state,
            @RequestParam("district") String district,
            @RequestParam("pinCode") Integer pinCode,
            @RequestParam("relationType") String relationType,
            @RequestParam("parentGuardianName") String ParentGuardianName,
            @RequestParam("parentGuardianContact") String ParentGuardianContact,
            @RequestParam("emergencyContactNumber") String emergencyContactNumber,
            @RequestParam("transportation") String transportation,
            @RequestParam("transportationPayment") Integer transportationPayment,
            @RequestParam("course") String course,
            @RequestParam("year") String year,
            @RequestParam("courseCode") String courseCode,
            @RequestParam("yearJoined") Integer yearJoined,
            @RequestParam("coursePaymentCost") Integer coursePaymentCost,
            @RequestParam("accommodationType") String accommodationType,
            @RequestParam("DHPayment") Integer DHPayment
    ) throws IOException {
        // Validation for required fields
        if (studentName.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Required fields are missing.");
        }

        // Validate file types and sizes
        validateFile(aadharFront, "Aadhar Front");
        validateFile(aadharB, "Aadhar Back");
        validateFile(photo, "Photo");

        // Save files and get their paths
        String aadharFrontPath = saveFile(aadharFront);
        String aadharBPath = saveFile(aadharB);
        String photoPath = saveFile(photo);

        // Create PersonalInfo object and set the values
        PersonalInfo student = new PersonalInfo();
        student.setStudentName(studentName);
        student.setEmail(email);
        student.setPhone(phone);
        student.setAadharFront(aadharFrontPath);
        student.setAadharB(aadharBPath);
        student.setPhoto(photoPath);
        student.setAddressLine1(addressLine1);
        student.setAddressLine2(addressLine2);
        student.setCountry(country);
        student.setState(state);
        student.setDistrict(district);
        student.setPinCode(pinCode);
        student.setRelationType(relationType);
        student.setParentGuardianName(ParentGuardianName);
        student.setParentGuardianContact(ParentGuardianContact);
        student.setEmergencyContactNumber(emergencyContactNumber);
        student.setTransportation(transportation);
        student.setTransportationPayment(transportationPayment);
        student.setCourse(course);
        student.setYear(year);
        student.setCourseCode(courseCode);
        student.setYearJoined(yearJoined);
        student.setCoursePaymentCost(coursePaymentCost);
        student.setAccommodationType(accommodationType);
        student.setDHPayment(DHPayment);

        try {
            personalInfoService.saveStudent(student);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new HashMap<String, String>() {{
                        put("status", "error");
                        put("message", "Failed to register student: " + e.getMessage());
                    }});

        }

        String enrollmentNumber = student.getEnrollmentNumber();
        if (enrollmentNumber == null || enrollmentNumber.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to generate enrollment number.");
        }

        return ResponseEntity.ok().body(new HashMap<String, String>() {{
            put("status", "success");
            put("message", "Candidate is Successfully Registered with Enrollment Number: " + enrollmentNumber);
        }});
    }

    private void validateFile(MultipartFile file, String fieldName) throws IOException {
        if (file.isEmpty()) {
            throw new IOException(fieldName + " file is missing!");
        }
        if (!file.getContentType().equalsIgnoreCase("image/jpeg") &&
                !file.getContentType().equalsIgnoreCase("image/png")) {
            throw new IOException(fieldName + " must be a JPG or PNG image!");
        }
        if (file.getSize() > 10 * 1024 * 1024) { // 10MB
            throw new IOException(fieldName + " exceeds the size limit of 10MB!");
        }
    }

    public static void createDirectoryIfNotExists() {
        Path path = Paths.get(BASE_DIRECTORY);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle error when creating the directory
            }
        }
    }

    // Save the file and return the path of the saved file
    public static Path saveImage(MultipartFile file) throws IOException {
        createDirectoryIfNotExists();

        // Generate a unique name for the image file
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(BASE_DIRECTORY + fileName);

        // Save the image file
        file.transferTo(filePath);

        return filePath; // Return the saved file path
    }

    // Alternative: Save file and return just the file name
    public static String saveFile(MultipartFile file) throws IOException {
        createDirectoryIfNotExists();

        // Generate a unique name for the file
        String uniqueFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(BASE_DIRECTORY + uniqueFileName);

        // Save the file
        file.transferTo(filePath);

        return uniqueFileName; // Return the unique file name (can be stored in the database)
    }
}

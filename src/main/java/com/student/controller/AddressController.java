package com.student.controller;

import com.student.model.Address;
import com.student.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // Endpoint to register address details
    @PostMapping("/register")
    public ResponseEntity<String> registerAddress(@RequestBody Address address) {
        addressService.saveAddress(address);
        return ResponseEntity.ok("Address details saved successfully for enrollment number: " + address.getEnrollmentNumber());
    }

    // Endpoint to retrieve address details by enrollment number
    @GetMapping("/{enrollmentNumber}")
    public ResponseEntity<Address> getAddress(@PathVariable String enrollmentNumber) {
        Address address = addressService.getAddressByEnrollmentNumber(enrollmentNumber);
        if (address != null) {
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

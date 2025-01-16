package com.student.service;

import com.student.model.Address;
import com.student.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void saveAddress(Address address) {
        // Save address details to the database
        addressRepository.save(address);
    }

    public Address getAddressByEnrollmentNumber(String enrollmentNumber) {
        // Retrieve address details by enrollment number
        return addressRepository.findByEnrollmentNumber(enrollmentNumber);
    }
}

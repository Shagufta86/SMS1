package com.student.service;

import com.student.model.Transportation;
import com.student.repository.TransportationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportationService {

    @Autowired
    private TransportationRepository transportationRepository;

    public void saveTransportationInfo(Transportation transportation) {
        // Save the Transportation info to the repository
        transportationRepository.save(transportation);
    }

    public Transportation getTransportationInfoById(Integer id) {
        return transportationRepository.findById(id).orElse(null);  // Return null if not found
    }
}

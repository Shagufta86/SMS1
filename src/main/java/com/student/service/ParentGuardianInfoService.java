package com.student.service;

import com.student.model.ParentGuardianInfo;
import com.student.repository.ParentGuardianInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentGuardianInfoService {

    @Autowired
    private ParentGuardianInfoRepository parentGuardianInfoRepository;

    public void saveParentGuardianInfo(ParentGuardianInfo parentGuardianInfo) {
        // Save the parent/guardian info to the repository
        parentGuardianInfoRepository.save(parentGuardianInfo);
    }

    public ParentGuardianInfo getParentGuardianInfoById(Integer id) {
        return null;
    }
}

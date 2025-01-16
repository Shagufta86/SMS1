package com.student.service;

import com.student.model.ScholarHosteller;
import com.student.repository.ScholarHostellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScholarHostellerService {

    @Autowired
    private ScholarHostellerRepository scholarHostellerRepository;

    public void saveScholarHostellerInfo(ScholarHosteller scholarHosteller) {
        // Save the ScholarHosteller info to the repository
        scholarHostellerRepository.save(scholarHosteller);
    }

    public ScholarHosteller getScholarHostellerInfoById(Integer id) {
        return null;
    }
}

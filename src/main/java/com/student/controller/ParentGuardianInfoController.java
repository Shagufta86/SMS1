package com.student.controller;

import com.student.model.ParentGuardianInfo;
import com.student.service.ParentGuardianInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parent-guardian")
public class ParentGuardianInfoController {

    @Autowired
    private ParentGuardianInfoService parentGuardianInfoService;

    // Endpoint to create or update Parent/Guardian info
    @PostMapping
    public ResponseEntity<String> createParentGuardianInfo(@RequestBody ParentGuardianInfo parentGuardianInfo) {
        parentGuardianInfoService.saveParentGuardianInfo(parentGuardianInfo);
        return ResponseEntity.ok("Parent/Guardian info saved successfully.");
    }

    // Endpoint to get Parent/Guardian info by ID
    @GetMapping("/{id}")
    public ResponseEntity<ParentGuardianInfo> getParentGuardianInfoById(@PathVariable Integer id) {
        ParentGuardianInfo parentGuardianInfo = parentGuardianInfoService.getParentGuardianInfoById(id);
        if (parentGuardianInfo != null) {
            return ResponseEntity.ok(parentGuardianInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.health.services.controllers;

import java.util.Map;

import com.health.services.models.Diagnosis;
import com.health.services.models.HealthProfile;
import com.health.services.repositories.DiagnosisRepository;
import com.health.services.repositories.HealthProfileRepository;
import com.health.services.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private HealthProfileRepository profileRepo;

    @Autowired
    private DiagnosisRepository diagnosisRepo;

    @GetMapping
    @ResponseBody
    public HealthProfile getProfile(@RequestParam("id") Long id) throws Exception {
        return profileRepo.findByUser(
            userRepo.findById(id)
            .orElseThrow(() -> new Exception("User not found"))
        );
    }

    @PostMapping
    @ResponseBody
    public HealthProfile create(@RequestBody Map<String, String> body, @RequestParam("id") Long id) throws Exception {
        Diagnosis diagnosis = new Diagnosis(body.get("ailments"));
        HealthProfile profile = new HealthProfile(
            userRepo.findById(id)
            .orElseThrow(() -> new Exception("User not found")),
            diagnosisRepo.save(diagnosis)
            );

        return profileRepo.save(profile);
    }
}
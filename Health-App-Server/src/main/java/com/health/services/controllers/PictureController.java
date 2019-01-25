package com.health.services.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.health.services.repositories.HealthProfileRepository;
import com.health.services.repositories.PictureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/picture")
public class PictureController {
    
    @Autowired
    private PictureRepository pictureRepo;

    @Autowired
    private HealthProfileRepository profileRepo;

    @PostMapping
    @ResponseBody
    public String upload(@RequestParam("id") Long id) {
        return "null";
    }
}
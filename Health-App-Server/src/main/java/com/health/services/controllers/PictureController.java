package com.health.services.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.health.services.models.Picture;
import com.health.services.models.HealthProfile;
import com.health.services.repositories.HealthProfileRepository;
import com.health.services.repositories.PictureRepository;
import com.health.services.exceptions.IncorrectMimeTypeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public String upload(@RequestParam("id") Long id, @RequestParam("picture") MultipartFile file) throws Exception {
        Picture picture = pictureRepo.findByData(file.getBytes());
        HealthProfile profile = profileRepo.findById(id).get();

        if (picture != null) {
            throw new Exception("Duplicate picture");
        }
        else {
            picture = pictureRepo.findByProfile(profile);

            if (picture != null) {
                if (!(file.getContentType().contains("image"))) {
                    throw new IncorrectMimeTypeException(String.format("Incorrect mime type. Requires an image but found %s", file.getContentType()));
                }
                else {
                   
                    picture.setContentType(file.getContentType());
                    picture.setData(file.getBytes());

                    pictureRepo.save(picture);

                    profile.setPicture(picture);

                    profileRepo.save(profile);

                    return "Picture successfully updated";
                }
            }
            else {
                if (!(file.getContentType().contains("image"))) throw new IncorrectMimeTypeException(String.format("Incorrect mime type. Requires an image but found %s", file.getContentType()));
                else {
                    
                    picture = new Picture(file.getContentType(), file.getBytes(), profileRepo.findById(id).get());

                    pictureRepo.save(picture);

                    profile.setPicture(picture);

                    profileRepo.save(profile);

                    return "Picture successfully uploaded";
                }
            }
        }
    }

    @DeleteMapping
    public void delete(@RequestParam("id") Long id) {
        pictureRepo.deleteById(id);
    }
}
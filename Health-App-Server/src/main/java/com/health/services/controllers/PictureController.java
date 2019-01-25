package com.health.services.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.health.services.models.Picture;
import com.health.services.repositories.HealthProfileRepository;
import com.health.services.repositories.PictureRepository;

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

        if (picture != null) {
            throw new Exception("Duplicate picture");
        }
        else {
            picture = pictureRepo.findByHealthProfile(profileRepo.getOne(id));

            if (picture != null) {
                if (!file.getContentType().contains("image")) throw new Exception("Upload an image");
                picture.setContentType(file.getContentType());
                picture.setData(file.getBytes());

                pictureRepo.save(picture);

                return "Picture successfully updated";
            }
            else {
                picture = new Picture(file.getContentType(), file.getBytes(), profileRepo.getOne(id));

                pictureRepo.save(picture);

                return "Picture successfully uploaded";
            }
        }
    }

    @DeleteMapping
    public void delete(@RequestParam("id") Long id) {
        pictureRepo.deleteById(id);
    }
}
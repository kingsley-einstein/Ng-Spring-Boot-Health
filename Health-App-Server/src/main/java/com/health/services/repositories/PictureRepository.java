package com.health.services.repositories;

import com.health.services.models.HealthProfile;
import com.health.services.models.Picture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findByData(byte[] data);
    Picture findByProfile(HealthProfile profile);
}
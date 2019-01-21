package com.health.services.repositories;

import com.health.services.models.Diagnosis;
import com.health.services.models.HealthProfile;
import com.health.services.models.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthProfileRepository extends JpaRepository<HealthProfile, Long> {
    HealthProfile findByUser(User user);
    Page<HealthProfile> findByDiagnosis(Diagnosis diagnosis, Pageable pageable);
}
package com.health.services.repositories;

import com.health.services.models.Diagnosis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
    Diagnosis findByAilmentsContaining(String ailment);   
}
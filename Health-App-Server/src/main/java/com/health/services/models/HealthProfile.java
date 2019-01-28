package com.health.services.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "profiles")
@Entity
public class HealthProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "profile")
    private Picture picture;

    @OneToOne
    private User user;

    @OneToOne
    private Diagnosis diagnosis;

    protected HealthProfile() {}

    public HealthProfile(User user, Diagnosis diagnosis) {
        this.user = user;
        this.diagnosis = diagnosis;
    }

    public User getUser() {
        return user;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public Picture getPicture() {
        return picture;
    }

    public Long getId() {
        return id;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
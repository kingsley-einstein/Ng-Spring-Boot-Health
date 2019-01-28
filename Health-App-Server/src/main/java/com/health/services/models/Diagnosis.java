package com.health.services.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "diagnosis")
@Entity
public class Diagnosis implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Ailments field must be filled")
    @Column(name = "ailments", nullable = false)
    private String ailments;

    @JsonIgnore
    @OneToOne(mappedBy = "diagnosis")
    private HealthProfile profile;

    protected Diagnosis() {}

    public Diagnosis(String ailments) {
        this.ailments = ailments;
    }

    public String getAilments() {
        return ailments;
    }

    public Long getId() {
        return id;
    }

    public void setAilments(String ailments) {
        this.ailments = ailments;
    }
}
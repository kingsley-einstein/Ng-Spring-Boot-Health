package com.health.services.models;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "pictures")
@Entity
public class Picture implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mimeType")
    private String contentType;

    @Column(name = "content", nullable = false, columnDefinition = "mediumBlob", unique = true)
    private Byte[] data;

    @JsonIgnore
    @OneToOne(mappedBy = "picture")
    private HealthProfile profile;

    protected Picture() {}

    public Picture(final String contentType, final Byte[] data, final HealthProfile profile) {
        this.contentType = contentType;
        this.data = data;
        this.profile = profile;
    }

    public String getContentType() {
        return contentType;
    }

    public Byte[] getData() {
        return data;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setData(Byte[] data) {
        this.data = data;
    }
}
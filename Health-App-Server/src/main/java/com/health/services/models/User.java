package com.health.services.models;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;

@Table(name = "users")
@Entity
public class User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 30, min = 5, message = "Invalid username")
    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username cannot be left empty")
    @Column(name = "username", unique = true)
    private String name;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be left empty")
    @Email(message = "Not a valid email")
    @Column(name = "email", unique = true)
    private String email;

    private String uniqueToken;

    protected User() {}

    public User(String name, String email, String uniqueToken) {
        this.name = name;
        this.email = email;
        this.uniqueToken = uniqueToken;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    public String getUniqueToken() {
        return uniqueToken;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
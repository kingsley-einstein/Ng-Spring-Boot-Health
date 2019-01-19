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
    @Column(name = "username")
    private String username;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be left empty")
    @Email(message = "Not a valid email")
    private String email;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "password cannot be empty")
    private String password;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    private String getPassword() {
        return password;
    }
}
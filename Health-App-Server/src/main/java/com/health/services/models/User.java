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
    private String username;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be left empty")
    @Email(message = "Not a valid email")
    @Column(name = "email", unique = true)
    private String email;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "password cannot be empty")
    private String password;

    protected User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    } 
}
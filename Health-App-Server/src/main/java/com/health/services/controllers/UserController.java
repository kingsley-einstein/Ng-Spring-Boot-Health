package com.health.services.controllers;

import java.util.Map;
import java.util.Optional;

import com.health.services.models.User;
import com.health.services.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @Value("${admin.password}")
    private String token;

    @PostMapping
    @ResponseBody
    public User create(@RequestBody Map<String, String> body) {
        User user = new User(body.get("name"), body.get("email"), BCrypt.hashpw(BCrypt.gensalt(2), token));

        return userRepo.save(user);
    }

    @GetMapping
    @ResponseBody
    public Optional<User> getUser(@RequestParam("id") Long id) {
        return userRepo.findById(id);
    }
}
package com.health.services.controllers;

import java.util.Map;

import com.health.services.models.User;
import com.health.services.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public User getUser(@RequestParam("email") String email) {
        return userRepo.findByEmail(email);
    }

    @GetMapping("/moniker")
    @ResponseBody
    public User getByName(@RequestParam("name") String name) {
        return userRepo.findByName(name);
    }

    @GetMapping("/unique_token")
    @ResponseBody
    public User getByToken(@RequestParam("token") String uniqueToken) {
        return userRepo.findByUniqueToken(uniqueToken);
    }   

    @DeleteMapping
    public void deleteRecord(@RequestParam("id") Long id) {
        userRepo.deleteById(id);
    }

    @DeleteMapping("/flush")
    public void deleteAll() {
        userRepo.deleteAll();
    }

    @PutMapping
    public void update(@RequestParam("id") Long id, @RequestParam("email") String email, @RequestParam("name") String name) throws Exception {
        User user = userRepo.findById(id)
            .orElseThrow(() -> new Exception("User not found"));
        
        user.setEmail(email);
        user.setName(name);

        userRepo.save(user);
    }
}
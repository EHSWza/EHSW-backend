package com.ehsw.demo.controllers;

import com.ehsw.demo.models.Users;
import com.ehsw.demo.repositories.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        try {
            String googleUserId = body.get("google_user_id");
            String role = body.get("role");

            if (googleUserId == null || role == null) {
                return ResponseEntity.badRequest().body("Missing google_user_id or role");
            }

            Optional<Users> existingUser = usersRepository.findByGoogleUserId(googleUserId);

            if (existingUser.isPresent()) {
                return ResponseEntity.ok("Login successful for existing user");
            }

            Users newUser = new Users(googleUserId, role, LocalDateTime.now());
            usersRepository.save(newUser);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("New user created successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the login request"+e.getMessage());
        }
    }

}

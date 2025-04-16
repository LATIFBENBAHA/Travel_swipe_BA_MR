package com.travel.swipe.controller;

import com.travel.swipe.dto.UserDTO;
import com.travel.swipe.exceptions.EmailAlreadyExistsException;
import com.travel.swipe.model.User;
import com.travel.swipe.repository.UserRepository;
import com.travel.swipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User savedUser = userService.saveUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT) // 409 Conflict est plus approprié que 400 Bad Request
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @GetMapping("/by-email")
    public ResponseEntity<User> getByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = userRepository.findByEmailAndMotdepass(
                loginRequest.getEmail(),
                loginRequest.getMotdepass()
        );
        if (user != null) {
            return ResponseEntity.ok(Map.of("user", new UserDTO(user)));

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect.");
        }
    }
}
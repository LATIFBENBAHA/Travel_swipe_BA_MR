package com.travel.swipe.controller;

import com.travel.swipe.model.User;
import com.travel.swipe.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public String createUser(@RequestBody User user) {
        userService.saveUser(user);
        return  "Utilisateur ajouté avec succès !";
    }
}
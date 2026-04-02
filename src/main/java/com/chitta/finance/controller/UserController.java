package com.chitta.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chitta.finance.entity.User;
import com.chitta.finance.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);

        if (user == null) {
            throw new RuntimeException("User not found with id: " + id);
        }

        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        User existingUser = userService.getUserById(id);

        if (existingUser == null) {
            throw new RuntimeException("User not found with id: " + id);
        }

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setStatus(updatedUser.getStatus());
        existingUser.setRole(updatedUser.getRole());

        return userService.saveUser(existingUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        User existingUser = userService.getUserById(id);

        if (existingUser == null) {
            throw new RuntimeException("User not found with id: " + id);
        }

        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
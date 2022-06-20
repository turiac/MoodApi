package com.proiectdb.moodapp.controller;

import com.proiectdb.moodapp.model.User;
import com.proiectdb.moodapp.model.dto.UserDto;
import com.proiectdb.moodapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@AllArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("users/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        userService.insert(user);
        return user;
    }

    @PostMapping("/users/update")
    public User updateUser(@RequestBody User user) {
        userService.update(user);
        return user;
    }

    @DeleteMapping("/users/deleted/{id}")
    public void deleteUser(@RequestBody User user) {
        userService.delete(user);
    }

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }
}


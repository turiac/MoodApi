package com.proiectdb.moodapp.controller;

import java.io.IOException;
import java.util.List;

import com.proiectdb.moodapp.model.DTO.UserDTO;
import com.proiectdb.moodapp.model.Manager;
import com.proiectdb.moodapp.model.Role;
import com.proiectdb.moodapp.model.User;
import com.proiectdb.moodapp.service.ManagerService;
import com.proiectdb.moodapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    private final UserService userService;


    private final ManagerService managerService;

    public UserController(UserService userService, ManagerService managerService) {
        this.userService = userService;
        this.managerService = managerService;
    }

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        List<Manager> listManagers = managerService.listAll();
        model.addAttribute("user", new User());
        model.addAttribute("listManagers", listManagers);

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userService.save(user);
        userService.setManagerId(user, user.getManager().getId());

        return "register_success";
    }

    @GetMapping("/list_users")
    public List<UserDTO> listAllUsers() {
        return userService.listAll().stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(java.util.stream.Collectors.toList());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        User user = userService.getById(id);
        UserDTO userResponse = modelMapper.map(user, UserDTO.class);
        return ResponseEntity.ok().body(userResponse);
    }

    @PutMapping("/user/edit/{id}")
    public Integer editUser(@PathVariable Long id, @RequestBody UserDTO userDTO, HttpServletResponse response) throws IOException {
        User userRequest = modelMapper.map(userDTO, User.class);
        userService.updateUser(id, userRequest);
        response.setStatus(201);
        return response.getStatus();
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        userService.save(user);

        return "redirect:/users";
    }
}
package com.proiectdb.moodapp.service;

import java.util.List;

import com.proiectdb.moodapp.model.Role;
import com.proiectdb.moodapp.model.User;
import com.proiectdb.moodapp.repository.RoleRepository;
import com.proiectdb.moodapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired PasswordEncoder passwordEncoder;

    public void registerDefaultUser(User user) {
        Role roleUser = roleRepository.findByName("User");
        user.addRole(roleUser);
        encodePassword(user);
        userRepository.save(user);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    public void save(User user) {
        encodePassword(user);
        userRepository.save(user);
    }

    public void saveManager(User user) {
        Role roleManager = roleRepository.findByName("Manager");
        user.addRole(roleManager);
        encodePassword(user);
        userRepository.save(user);
    }

    public void setManagerId(User user, Long managerId) {
        Role roleEmployee = roleRepository.findByName("employee");
        user.addRole(roleEmployee);
        user.setManager(managerService.get(managerId));
        userRepository.save(user);
    }

    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
}
package com.proiectdb.moodapp.repository;

import com.proiectdb.moodapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User findByUserId(Long userId);
    List<User> findAll();
}


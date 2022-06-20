package com.proiectdb.moodapp.repository;

import com.proiectdb.moodapp.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Manager findByName(String name);
    Manager findByManagerId(Long managerId);
    List<Manager> findAll();
}


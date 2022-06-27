package com.proiectdb.moodapp.repository;

import com.proiectdb.moodapp.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    @Query("SELECT u FROM Manager u WHERE u.email = ?1")
    public Manager findByEmail(String email);
}


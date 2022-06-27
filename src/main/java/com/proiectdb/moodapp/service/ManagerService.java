package com.proiectdb.moodapp.service;

import com.proiectdb.moodapp.model.Manager;
import com.proiectdb.moodapp.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public void registerDefaultManager(Manager manager) {
        managerRepository.save(manager);
    }

    public List<Manager> listAll() {
        return managerRepository.findAll();
    }

    public Manager get(Long id) {
        return managerRepository.findById(id).get();
    }

    public void save(Manager manager) {
        managerRepository.save(manager);
    }

    public void delete(Long id) {
        managerRepository.deleteById(id);
    }




}

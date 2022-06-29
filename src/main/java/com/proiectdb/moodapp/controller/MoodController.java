package com.proiectdb.moodapp.controller;

import com.proiectdb.moodapp.model.Mood;
import com.proiectdb.moodapp.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class MoodController {

    @Autowired
    private MoodService moodService;

    @PostMapping("/new-mood")
    public Mood createMood(@RequestBody Mood mood) {
        mood.setDate(LocalDate.now());
        return moodService.createMood(mood);
    }

    @GetMapping("/get-mood/{id}")
    public Mood getMoodById(@PathVariable Long id) {
        return moodService.getMoodById(id);
    }
}

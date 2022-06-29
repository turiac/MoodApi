package com.proiectdb.moodapp.controller;

import com.proiectdb.moodapp.model.EmailDetails;
import com.proiectdb.moodapp.model.Mood;
import com.proiectdb.moodapp.service.EmailService;
import com.proiectdb.moodapp.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class MoodController {

    @Autowired
    private MoodService moodService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/new-mood")
    public Mood createMood(@RequestBody Mood mood) {
        mood.setDate(LocalDate.now());
        if(mood.getValue() < 5){
            EmailDetails details = new EmailDetails();
            details.setRecipient("ureaalex@gmail.com");
            details.setSubject("sad employee");
            details.setMsgBody(" had a bad day");
            emailService.sendSimpleMail(details);
        }
        return moodService.createMood(mood);
    }

    @GetMapping("/get-mood/{id}")
    public Mood getMoodById(@PathVariable Long id) {
        return moodService.getMoodById(id);
    }

}




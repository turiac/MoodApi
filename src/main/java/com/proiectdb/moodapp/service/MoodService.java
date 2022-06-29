package com.proiectdb.moodapp.service;

import com.proiectdb.moodapp.model.Mood;
import com.proiectdb.moodapp.model.User;
import com.proiectdb.moodapp.repository.MoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MoodService {

    @Autowired
    private  MoodRepository moodRepository;


    public Mood getMoodById(Long id) {
        return moodRepository.findById(id).get();
    }

    public Mood getMoodByDate(String date) {
        return moodRepository.getAllByDate(date);
    }

    public Mood getMoodByDateAndId(String date, Long id) {
        return moodRepository.getAllByDateAndId(date, id);
    }

    public Mood createMood(Mood mood) {
        return moodRepository.save(mood);
    }

    public void save(Mood mood) {
        moodRepository.save(mood);
    }

    public void delete(Long id) {
        moodRepository.deleteById(id);
    }


}

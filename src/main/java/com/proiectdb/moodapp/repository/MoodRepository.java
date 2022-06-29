package com.proiectdb.moodapp.repository;

import com.proiectdb.moodapp.model.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {
    public Mood findAllById(Long id);

    public Mood getAllByDate(String date);

    public Mood getAllByDateAndId(String date, Long id);
}

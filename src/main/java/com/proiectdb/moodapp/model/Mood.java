package com.proiectdb.moodapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mood {
    @Id
    @GeneratedValue
    private Long id;
    private Integer value;
    private LocalDate date;
    private String justification;
    private String improvement;

    @ManyToOne
    private User user;
}

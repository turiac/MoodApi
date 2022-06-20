package com.proiectdb.moodapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private Long userId;

    private String name;
    private String email;
    private String password;
    private String role;

    @ManyToOne
    private Manager manager;
}

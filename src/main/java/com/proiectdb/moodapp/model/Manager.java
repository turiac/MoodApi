/* package com.proiectdb.moodapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Manager {

    @Id
    @GeneratedValue
    private Long managerId;

    private String name;
    private String email;
    private String password;
    private String role;

    @OneToMany(mappedBy = "manager")
    private List<User> users;
}
*/





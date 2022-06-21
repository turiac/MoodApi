package com.proiectdb.moodapp;

import static org.assertj.core.api.Assertions.assertThat;

import com.proiectdb.moodapp.model.User;
import com.proiectdb.moodapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("turiacalexandrudan@gmail.com");
        user.setPassword("dbcloudschool");
        user.setFirstName("Alex");
        user.setLastName("Turiac");

        User savedUser = userRepository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }

    @Test
    public void testFindByEmail() {
        String email = "turiacalexandrudan@gmail.com";
        User user = userRepository.findByEmail(email);

        assertThat(user.getEmail()).isEqualTo(email);
    }
}

package com.gfa.springsecmysqlfirst;

import com.gfa.springsecmysqlfirst.models.User;
import com.gfa.springsecmysqlfirst.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecMysqlFirstApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public SpringSecMysqlFirstApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecMysqlFirstApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("user1", "passuser1", true, "ROLE_USER"));
        userRepository.save(new User("user2", "passuser2", true, "ROLE_ADMIN"));
        userRepository.save(new User("user3", "passuser3", true, "ROLE_USER, ROLE_ADMIN"));
    }
}

package com.managesystem.dentalclinic.login;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordAdmin = passwordEncoder.encode("pass");
        String passwordUser = passwordEncoder.encode("password");

        userRepository.save(new AppUser("admin", "admin", "admin@digital.com", passwordAdmin, AppUserRol.ADMIN));
        userRepository.save(new AppUser("user", "user", "user@digital.com", passwordUser, AppUserRol.USER));

    }

}

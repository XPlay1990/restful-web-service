package com.qad.restfulwebservice.jwt.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JanCreator {
    @Autowired
    private UserRepository userRepository;

    public void execute(){
        JwtUser jan = new JwtUser();
        jan.setEmail("j_adamczyk@hotmail.com");
        jan.setFirstName("Jan");
        jan.setLastName("Adamczyk");
        jan.setUsername("XPlay");
        jan.setPassword("$2a$10$cJTYjQ5wj.w8cGiYxqEy6.j4rLBJ5Lprdx7Iz2QGxZbfQxPhsAgRS");
        jan.activateUser();


        UserRole admin = new UserRole();
        admin.setAuthority("admin");
        ArrayList<UserRole> userRoles = new ArrayList<>();
        userRoles.add(admin);
        jan.setAuthorities(userRoles);

        if(userRepository == null){
            System.out.println("WTF ITS NULL");
        }

        userRepository.save(jan);
    }
}

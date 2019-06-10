package com.stackroute.seedData;

import com.stackroute.domain.User;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SeedDataUsingCommandLineRunner implements CommandLineRunner {

    @Value("${user1-id}")
    private int id;
    @Value("${user1-name}")
    private String name;
    @Value(("${user1-age}"))
    private int age;

    @Autowired
    Environment environment;
    @Autowired
    UserService userService;

    User user=new User();

    @Override
    public void run(String... args) throws Exception {

        //Prefilling Data
  user.setId(14);
        user.setName("Kooel");
        user.setAge(35);
        userService.addNewUser(user);


      //Removing Hardcoded Data and shifting to application.properties
      user.setId(id);
      user.setName(name);
      user.setAge(age);
      userService.addNewUser(user);
    }
}

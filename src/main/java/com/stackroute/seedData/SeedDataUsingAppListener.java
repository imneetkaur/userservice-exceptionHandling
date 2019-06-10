package com.stackroute.seedData;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SeedDataUsingAppListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Environment environment;

    @Autowired
    UserRepository userRepository;
    User user=new User();


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        //Prefilling Data
        user.setId(15);
        user.setName("Gagan");
        user.setAge(24);
        userRepository.save(user);


        //Removing Hardcoded Data and shifting to application.properties
        user.setId(Integer.parseInt(environment.getProperty("user2-id")));
        user.setName(environment.getProperty("user2-name"));
        user.setAge(Integer.parseInt(environment.getProperty("user2-age")));
        userRepository.save(user);
    }
}

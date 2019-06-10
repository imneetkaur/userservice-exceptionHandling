package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.exceptions.UserNotFoundException;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User addNewUser(User user) throws UserAlreadyExistsException,UserNotFoundException{
        if(userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistsException("User Already Exists");
        }
        User saveNewUser = userRepository.save(user);
        if(saveNewUser==null){
            throw new UserNotFoundException("User Not Found");}
        return saveNewUser;
    }


    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findUserById(int id) throws UserNotFoundException {
        User user;
        if(userRepository.findById(id).isEmpty()){
            throw new UserNotFoundException("User Not Found");
        }else {
            user = userRepository.findById(id).get();
        }
        return user;
    }

    @Override
    public void deleteUserById(int id) throws UserNotFoundException {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        else{
            throw new UserNotFoundException("User Not Found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

}

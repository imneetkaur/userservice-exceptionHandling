package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public User addNewUser(User user) throws UserAlreadyExistsException,UserNotFoundException;
    public List<User> getAllUsers();
    public User findUserById(int id) throws UserNotFoundException;
    public void deleteUserById(int id) throws UserNotFoundException;
    public void deleteAllUsers();

}

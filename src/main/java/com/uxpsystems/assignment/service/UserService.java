package com.uxpsystems.assignment.service;

import com.uxpsystems.assignment.dao.UserDocument;
import com.uxpsystems.assignment.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UserService
 */
@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDocument findById(long id) {
        return userRepository.findById(id);
    }

    public void save(UserDocument user) {
        userRepository.save(user);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

}

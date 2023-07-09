package com.example.EcommerceAPI.services;

import com.example.EcommerceAPI.models.User;
import com.example.EcommerceAPI.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User createUser(User user) {
        return userDao.save(user);
    }


    public Optional<User> getUserById(Integer userId) {
        return userDao.findById(userId);
    }
}

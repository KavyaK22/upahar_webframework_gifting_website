package com.example.cc1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cc1.model.User;
import com.example.cc1.repository.UserRepository;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    public User getUser(int id)
    {
        return userRepository.findById(id).orElse(null);
    }

    //deleting by id
    public void deleteUser(int id)
    {
        userRepository.deleteById(id);
    }
}

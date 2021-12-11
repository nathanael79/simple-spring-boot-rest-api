package com.learn.restapi.service;

import java.util.List;

import javax.transaction.Transactional;

import com.learn.restapi.model.User;
import com.learn.restapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUser()
    {
        return userRepository.findAll();
    }

    public void saveUser(User user)
    {
        userRepository.save(user);
    }

    public User getUser(Integer id)
    {
        return userRepository.findById(id).get();
    }

    public void deleteUser(Integer id)
    {
        userRepository.deleteById(id);
    }
    
}

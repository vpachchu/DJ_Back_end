package com.example.dj_user_details.service;

import com.example.dj_user_details.model.User;
import com.example.dj_user_details.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User fetchUserById(int uid) {
        Optional<User> user= userRepository.findById(uid);

        if(user.isPresent())
        {
           return user.get();
        }
        return  null;
    }

    @Override
    public List<User> fetchAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List <User> findUserByUsername(String username) {
       List<User> user=userRepository.findByUsername(username);
       if(user.isEmpty())
       {
           return null;
       }
       return user;
    }
}

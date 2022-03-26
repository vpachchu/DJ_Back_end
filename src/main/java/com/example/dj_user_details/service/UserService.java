package com.example.dj_user_details.service;

import com.example.dj_user_details.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User save(User user);
    User fetchUserById(int uid);
    List <User> fetchAll();

}

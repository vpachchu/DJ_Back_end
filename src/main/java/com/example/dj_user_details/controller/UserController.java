package com.example.dj_user_details.controller;

import com.example.dj_user_details.model.User;
import com.example.dj_user_details.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/user", method = RequestMethod.POST)
    public User save(@RequestBody User user){
        System.out.println(user.getName());
        System.out.println(user.getEmail());
      return   userService.save(user);
    }

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public ResponseEntity<User> fetchById(@RequestParam int uid)
    {
        User user=userService.fetchUserById(uid);
        if(user==null)
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok().body(user);
        }
    }

    @RequestMapping(value="/fetchAll", method = RequestMethod.GET)
    public List<User> fetchAll()
    {
        return userService.fetchAll();
    }

}

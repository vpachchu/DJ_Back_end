package com.example.dj_user_details.controller;

import com.example.dj_user_details.model.User;
import com.example.dj_user_details.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;


   @RequestMapping(value ="/user",method=RequestMethod.POST)
    public User save(@RequestBody User user){
      return   userService.save(user);
    }

    @RequestMapping(value="/user/{uid}",method=RequestMethod.GET)
    public ResponseEntity<User> fetchById(@PathVariable int uid)
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


    @RequestMapping(value="/user",method=RequestMethod.DELETE)
    public void deleteUser(@RequestBody User user)
    {
        userService.delete(user);
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public ResponseEntity <List<User>> getByUsername(@RequestParam String username)
    {
        List <User> user=userService.findUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/fetchAll", method = RequestMethod.GET)
    public List<User> fetchAll()
    {
        return userService.fetchAll();
    }

}

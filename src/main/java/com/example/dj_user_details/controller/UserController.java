package com.example.dj_user_details.controller;

import com.example.dj_user_details.model.Diary;
import com.example.dj_user_details.model.User;
import com.example.dj_user_details.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;


   @RequestMapping(value ="/user",method=RequestMethod.POST)
    public User save(@RequestBody User user){
      return   userService.save(user);
    }

    @RequestMapping(value="/user",method=RequestMethod.GET)
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

    @RequestMapping(value="/user",method = RequestMethod.PUT)
    public User updateUserDetails(@RequestBody User newuser,@RequestParam int uid)
    {
        return userService.updateUser(newuser,uid);
    }

    @RequestMapping(value="/user",method=RequestMethod.DELETE)
    public void deleteUser(@RequestBody User user)
    {
        userService.delete(user);
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public ResponseEntity <User> getByUsername(@RequestParam String username,@RequestParam String password)
    {
        List <User> userlist=userService.findUserByUsername(username);
        User finduser= new User();

        for(User user:userlist)
        {
            if(user.getusername().equals(username) && user.getPassword().equals(password))
            {
                finduser=user;
                return ResponseEntity.ok().body(finduser);
            }


        }
        return (ResponseEntity.notFound().build());

    }

    @RequestMapping(value="/fetchAll", method = RequestMethod.GET)
    public List<User> fetchAll()
    {
        return userService.fetchAll();
    }

//    @RequestMapping(value="/userDiary",method = RequestMethod.GET)
//    public List<Diary> getDiaryDetailsByUid(@RequestParam int uid)
//    {
//
//        return userService.fetchDiaryDetailByUid(uid);
//    }

}

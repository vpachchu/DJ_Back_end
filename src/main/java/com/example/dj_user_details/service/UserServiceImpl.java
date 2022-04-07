package com.example.dj_user_details.service;

import com.example.dj_user_details.model.Diary;
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


    @Override
    public User updateUser(User newuser,int uid)
    {
        return userRepository.findById(uid)
                .map(user -> {
                    user.setName(newuser.getName());
                    user.setEmail(newuser.getEmail());
                    user.setusername(newuser.getusername());
                    user.setPassword(newuser.getPassword());

                    return userRepository.save(user);

                })
                .orElseGet(()->{
                    newuser.setuid(uid);
                    return userRepository.save(newuser);
                });

    }

//    @Override
//    public List<Diary> fetchDiaryDetailByUid(int uid) {
//        return userRepository.findDiaryByUid(uid);
//    }
}

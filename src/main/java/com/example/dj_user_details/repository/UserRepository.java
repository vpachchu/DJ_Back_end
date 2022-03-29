package com.example.dj_user_details.repository;

import com.example.dj_user_details.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
 List <User> findByUsername(String username);

}

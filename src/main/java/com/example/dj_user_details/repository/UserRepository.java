package com.example.dj_user_details.repository;

import com.example.dj_user_details.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

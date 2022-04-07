package com.example.dj_user_details.repository;

import com.example.dj_user_details.model.Diary;
import com.example.dj_user_details.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
 List <User> findByUsername(String username);

//@Query(value = "select new com.example.dj_user_details(diary_details.diary) from diary_details where diary_details.user_uid=?1",
//        nativeQuery = true)
// List<Diary> findDiaryByUid(int uid);

}

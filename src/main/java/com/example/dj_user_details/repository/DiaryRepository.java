package com.example.dj_user_details.repository;

import com.example.dj_user_details.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary,Integer> {

}

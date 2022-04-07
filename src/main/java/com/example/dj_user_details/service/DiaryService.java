package com.example.dj_user_details.service;

import com.example.dj_user_details.model.Diary;

import java.util.Optional;

public interface DiaryService {
    Diary save(Diary diary);
    Diary fetchDiaryById(int did);
    void deleteDiary(Diary diary);
    Diary updateDiary(Diary diary,int did);

}

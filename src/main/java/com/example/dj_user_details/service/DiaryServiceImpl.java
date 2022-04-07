package com.example.dj_user_details.service;

import com.example.dj_user_details.model.Diary;
import com.example.dj_user_details.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DiaryServiceImpl implements DiaryService{
    @Autowired
    DiaryRepository diaryRepository;

    @Override
    public Diary save(Diary diary) {
        return diaryRepository.save(diary);
    }

    @Override
    public Diary fetchDiaryById(int did) {
        Optional<Diary> diary = diaryRepository.findById(did);
        if(diary.isPresent())
        {
            return diary.get();
        }
        return null;
    }

    @Override
    public void deleteDiary(Diary diary) {
         diaryRepository.delete(diary);
    }

    @Override
    public Diary updateDiary(Diary newDiary,int did) {
        return diaryRepository.findById(did)
                .map(diary -> {
                    diary.setDiary(newDiary.getDiary());
                    diary.setClimate(newDiary.getClimate());
                    diary.setLastEdited(new Date());

                    return save(diary);

                }).orElseGet(() -> {
                    newDiary.setDid(did);
                    return diaryRepository.save(newDiary);
                });

    }
}

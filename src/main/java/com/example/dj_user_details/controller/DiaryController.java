package com.example.dj_user_details.controller;

import com.example.dj_user_details.model.Diary;
import com.example.dj_user_details.model.User;
import com.example.dj_user_details.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiaryController {
    @Autowired
    DiaryService diaryService;

    @RequestMapping(value="/diary" ,method = RequestMethod.POST)
    public Diary save(@RequestBody Diary diary){
       return diaryService.save(diary);
    }

    @RequestMapping(value="/diary" ,method = RequestMethod.GET)
    public ResponseEntity<Diary> fetchDiaryById(@RequestParam int did)
    {
       Diary diary=diaryService.fetchDiaryById(did);
        if(diary==null)
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok().body(diary);
        }

    }

    @RequestMapping(value="/diary" ,method = RequestMethod.DELETE)
    public void deleteDiary(@RequestParam int did,Diary diary)
    {
        diaryService.deleteDiary(diary);
    }

    @RequestMapping(value="/diary" ,method = RequestMethod.PUT)
    public Diary updateDiary(@RequestParam int did,@RequestBody Diary diary)
    {
        return diaryService.updateDiary(diary,did);
    }
}

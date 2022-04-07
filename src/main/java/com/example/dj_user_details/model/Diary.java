package com.example.dj_user_details.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="diaryDetails")
public class Diary {



//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "uid_uid")

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int did;
    private String diary;
    private String climate;
    private Date date= new Date();
    private Date lastEdited = new Date();



    //Diary belongs to a user
    @ManyToOne
    @JsonBackReference
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDiary() {
        return diary;
    }

    public void setDiary(String diary) {
        this.diary = diary;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }



}

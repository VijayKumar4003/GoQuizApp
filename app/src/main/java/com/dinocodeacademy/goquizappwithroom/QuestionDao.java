package com.dinocodeacademy.goquizappwithroom;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {

   @Query("SELECT * from questions_table")
   LiveData<List<Questions>> getAllQuestions();

   @Insert
    void insert(Questions questions);

}

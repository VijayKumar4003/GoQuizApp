package com.dinocodeacademy.goquizappwithroom;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class QuestionsRepository {


    private QuestionDao mQuestionDao;
    private LiveData<List<Questions>> mAllQuestions;


    public QuestionsRepository(Application application){
        QuestionRoomDatabase db = QuestionRoomDatabase.getInstance(application);
        mQuestionDao = db.questionDao();
        mAllQuestions = mQuestionDao.getAllQuestions();
    }


    public LiveData<List<Questions>> getmAllQuestions(){
        return mAllQuestions;
    }




}

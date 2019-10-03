package com.dinocodeacademy.goquizappwithroom;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class QuestionViewModel extends AndroidViewModel {

    private QuestionsRepository mRepository;

    private LiveData<List<Questions>> mAllQuestions;

    public QuestionViewModel(Application application){
        super(application);
        mRepository = new QuestionsRepository(application);
        mAllQuestions = mRepository.getmAllQuestions();

    }

    LiveData<List<Questions>> getmAllQuestions()
    {
      return mAllQuestions;
    }
}

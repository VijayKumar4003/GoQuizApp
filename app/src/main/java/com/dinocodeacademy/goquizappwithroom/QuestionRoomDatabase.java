package com.dinocodeacademy.goquizappwithroom;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Questions.class},version = 1)
public abstract class QuestionRoomDatabase extends RoomDatabase {

    private static QuestionRoomDatabase INSTANCE;


    public abstract QuestionDao questionDao();

    public static synchronized QuestionRoomDatabase getInstance(final Context context){

        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                       QuestionRoomDatabase.class, "questions_database")
                        .fallbackToDestructiveMigration()
                         .addCallback(RoomDBCallback)
                         .build();
        }

        return INSTANCE;

    }

    private static RoomDatabase.Callback RoomDBCallback = new RoomDatabase.Callback(){


        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);


            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{

        private QuestionDao questionDao;


       private PopulateDbAsyncTask(QuestionRoomDatabase db){

           questionDao = db.questionDao();

        }

        @Override
        protected Void doInBackground(Void... voids){


           questionDao.insert(new Questions("What is Android?","OS","Browser","Software","Hard Drive",1));
           questionDao.insert(new Questions("RAM Stands for what ?","Operating System","Browser","Random Access Memory","CD Project",3));
           questionDao.insert(new Questions("Chrome is what ?","System Software","Browser","Middle Ware","Windows",2));
           questionDao.insert(new Questions("HTML is what ?","Scipting Language","Programming Language","Software","Hyper Text Markup Language",4));
           questionDao.insert(new Questions("Unity is used for ?","Game Developement","Web Development","Graphics Design","3-D Modling",2));
           questionDao.insert(new Questions("What is OS","Hardware","System Software","PC Software","Hard Drive",2));
           questionDao.insert(new Questions("IP stand for what? ","Language","Intenet Protocol","Graphics","Random",2));
            return null;
        }
    }



}

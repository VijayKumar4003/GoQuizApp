package com.dinocodeacademy.goquizappwithroom;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class SplashAcitivity extends AppCompatActivity {


    private final static int EXIT_CODE = 100;

    ImageView imageViewSplashLogo;
    TextView textViewGoQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageViewSplashLogo = findViewById(R.id.splash_imgView);
        textViewGoQuiz = findViewById(R.id.txt_Splash_logo_text);


        Animation animation = AnimationUtils.loadAnimation(this,R.anim.transition);
        imageViewSplashLogo.setAnimation(animation);
        textViewGoQuiz.setAnimation(animation);


       Thread thread = new Thread(new Runnable() {
           @Override
           public void run() {


               try {
                   sleep(3000);

               }catch (Exception e)
               {
                   e.printStackTrace();

               }finally {

                   GoPlayActivity();
               }



           }
       });
       thread.start();


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EXIT_CODE){

            if (resultCode == RESULT_OK){
                if (data.getBooleanExtra("EXIT",true)){
                    finish();
                }

            }
        }
    }

    private void GoPlayActivity() {

        startActivityForResult(new Intent(SplashAcitivity.this,PlayActivity.class),EXIT_CODE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }


}

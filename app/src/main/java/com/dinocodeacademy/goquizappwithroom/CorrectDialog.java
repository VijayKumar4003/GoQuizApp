package com.dinocodeacademy.goquizappwithroom;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CorrectDialog {

    private Context mContext;
    private Dialog correctDialog;

    private QuizActivity mquizActivity;

    public CorrectDialog(Context mContext) {
        this.mContext = mContext;
    }

    public void correctDialog(int score,QuizActivity quizActivity){

        mquizActivity = quizActivity;


        correctDialog = new Dialog(mContext);

        correctDialog.setContentView(R.layout.correct_dialog);
        final Button btcorrectDialog = (Button) correctDialog.findViewById(R.id.bt_Score_Dialog);

        Score(score);  //  calling method

        btcorrectDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                correctDialog.dismiss();
                mquizActivity.setQuestionView();

            }
        });

        correctDialog.show();
        correctDialog.setCancelable(false);
        correctDialog.setCanceledOnTouchOutside(false);
        correctDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void Score(int score) {

        TextView textScore = (TextView) correctDialog.findViewById(R.id.textView_Score);
        textScore.setText("Score: " + String.valueOf(score));
    }

    
}

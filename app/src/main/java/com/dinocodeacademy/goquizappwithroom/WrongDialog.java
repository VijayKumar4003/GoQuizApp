package com.dinocodeacademy.goquizappwithroom;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class WrongDialog {

    private Context mContext;
    private Dialog wrongAnswerDialog;

    private QuizActivity mquizActivity;


    WrongDialog(Context mContext) {
        this.mContext = mContext;
    }

    void WrongDialog(String correctAnswer,QuizActivity quizActivity){

        mquizActivity = quizActivity;
        wrongAnswerDialog = new Dialog(mContext);
        wrongAnswerDialog.setContentView(R.layout.wrong_dialog);
        final Button btwrongAnswerDialog = (Button) wrongAnswerDialog.findViewById(R.id.bt_wrongDialog);
        TextView textView = (TextView) wrongAnswerDialog.findViewById(R.id.textView_Correct_Answer);

        textView.setText("Correct Ans: " + correctAnswer);

        btwrongAnswerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wrongAnswerDialog.dismiss();
                mquizActivity.setQuestionView();
            }
        });

        wrongAnswerDialog.show();
        wrongAnswerDialog.setCancelable(false);
        wrongAnswerDialog.setCanceledOnTouchOutside(false);

        wrongAnswerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
    
}

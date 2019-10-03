package com.dinocodeacademy.goquizappwithroom;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerDialog {

    private Context mContext;
    private Dialog timerDialog;


    TimerDialog(Context mContext) {
        this.mContext = mContext;
    }

    public void timerDialog(){


        timerDialog = new Dialog(mContext);

        timerDialog.setContentView(R.layout.timer_dialog);
        final Button bttimerDialog = (Button) timerDialog.findViewById(R.id.bt_timerDialog);


        bttimerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timerDialog.dismiss();
                Intent intent = new Intent(mContext,PlayActivity.class);
                mContext.startActivity(intent);

            }
        });

        timerDialog.show();
        timerDialog.setCancelable(false);
        timerDialog.setCanceledOnTouchOutside(false);
        timerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }


}

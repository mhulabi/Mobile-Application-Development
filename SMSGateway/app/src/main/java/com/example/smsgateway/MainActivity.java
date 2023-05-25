package com.example.smsgateway;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public Button START, STOP;
    public TextView textview;
    public int CountSms = 0;
    SMS sms =  new SMS(textview, CountSms);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout l1 = new LinearLayout(this);
        l1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.setGravity(Gravity.BOTTOM);
        LP.weight = 0.5f;
        LP.height = 150;
        LP.setMargins(30, 600, 30, 100);
        textview = new TextView(this);
        textview.setTextColor(Color.BLACK);
        textview.setGravity(Gravity.CENTER);
        textview.setText("Sent SMS Messages: " + CountSms);
        textview.setTextSize(20);
        START = new Button(this);
        START.setText("Start");
        START.setOnClickListener(this);
        START.setId((int) 0);
        START.setBackgroundColor(0xFFB3B3B3);
        STOP = new Button(this);
        STOP.setText("Stop");
        STOP.setOnClickListener(this);
        STOP.setId((int) 1);
        STOP.setBackgroundColor(0xFFB3B3B3);
        ll.setGravity(Gravity.CENTER | Gravity.BOTTOM);
        l1.setGravity(Gravity.CENTER_HORIZONTAL);
        ll.addView(textview);
        l1.addView(START, LP);
        l1.addView(STOP, LP);
        ll.addView(l1);
        setContentView(ll);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case 0: //START
                if (sms.flag == false){
                    sms = new SMS(textview, CountSms);
                    sms.execute();
                    sms.flag = true;
                }
                break;
            case 1: //STOP
                if (sms.flag == true){
                    CountSms = sms.getI();
                    sms.flag = false;
                    sms.cancel(true);
                }
                break;
            default:
                break;
        }
    }
}


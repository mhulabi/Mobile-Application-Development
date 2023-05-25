package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Controller control;
    public TextView result;
    public Button C, ADD, SUB, MUL, DIV, EQ, D, NEG, PER;
    public Button[] nums = new Button[10];
    public float a, b, per;
    public String op, input = "";
    public boolean opflag = false, dflag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        control = new Controller(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.setGravity(Gravity.BOTTOM);
        LP.weight = 1.0f;
        LP.height = 250;
        LP.setMargins(3, 3, 3, 3);
        LinearLayout.LayoutParams LPZ = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LPZ.weight = 9.0f;
        LPZ.height = 250;
        LPZ.setMargins(3, 3, 3, 3);
        LinearLayout l1 = new LinearLayout(this);
        l1.setOrientation(LinearLayout.HORIZONTAL);
        l1.setMinimumHeight(LP.height);
        l1.setGravity(Gravity.RIGHT);
        LinearLayout l2 = new LinearLayout(this);
        l2.setOrientation(LinearLayout.HORIZONTAL);
        l2.setMinimumHeight(LP.height);
        l2.setGravity(Gravity.RIGHT);
        LinearLayout l3 = new LinearLayout(this);
        l3.setOrientation(LinearLayout.HORIZONTAL);
        l3.setMinimumHeight(LP.height);
        l3.setGravity(Gravity.RIGHT);
        LinearLayout l4 = new LinearLayout(this);
        l4.setOrientation(LinearLayout.HORIZONTAL);
        l4.setMinimumHeight(LP.height);
        l4.setGravity(Gravity.RIGHT);
        LinearLayout l5 = new LinearLayout(this);
        l5.setOrientation(LinearLayout.HORIZONTAL);
        l5.setMinimumHeight(LP.height);
        l5.setGravity(Gravity.RIGHT);
        result = new TextView(this);
        result.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
        result.setTextColor(Color.WHITE);
        result.setGravity(Gravity.RIGHT);
        C = new Button(this);
        C.setText("C");
        C.setOnClickListener(this);
        C.setId((int) 10);
        C.setTextColor(Color.BLACK);
        C.setBackgroundColor(0xFFB3B3B3);
        ADD = new Button(this);
        ADD.setText("+");
        ADD.setOnClickListener(this);
        ADD.setId((int) 12);
        ADD.setBackgroundColor(0xFFFF6600);
        SUB = new Button(this);
        SUB.setText("-");
        SUB.setOnClickListener(this);
        SUB.setId((int) 13);
        SUB.setBackgroundColor(0xFFFF6600);
        MUL = new Button(this);
        MUL.setText("x");
        MUL.setOnClickListener(this);
        MUL.setId((int) 14);
        MUL.setBackgroundColor(0xFFFF6600);
        DIV = new Button(this);
        DIV.setText("/");
        DIV.setOnClickListener(this);
        DIV.setId((int) 15);
        DIV.setBackgroundColor(0xFFFF6600);
        EQ = new Button(this);
        EQ.setText("=");
        EQ.setOnClickListener(this);
        EQ.setId((int) 16);
        EQ.setBackgroundColor(0xFFFF6600);
        D = new Button(this);
        D.setText(".");
        D.setOnClickListener(this);
        D.setId((int) 17);
        D.setTextColor(Color.BLACK);
        D.setBackgroundColor(0xFFB3B3B3);
        NEG = new Button(this);
        NEG.setText("+/-");
        NEG.setOnClickListener(this);
        NEG.setId((int) 18);
        NEG.setTextColor(Color.BLACK);
        NEG.setBackgroundColor(0xFFB3B3B3);
        PER = new Button(this);
        PER.setText("%");
        PER.setOnClickListener(this);
        PER.setId((int) 11);
        PER.setTextColor(Color.BLACK);
        PER.setBackgroundColor(0xFFB3B3B3);
        for (int i = 0; i < 10; i++){
            nums[i] = new Button(this);
            nums[i].setText(Integer.toString(i));
            nums[i].setOnClickListener(this);
            nums[i].setId(i);
            nums[i].setTextColor(Color.BLACK);
            nums[i].setBackgroundColor(0xFFB3B3B3);
        }
        result.setText("");
        ll.addView(result);
        l1.addView(C, LP);
        l1.addView(NEG, LP);
        l1.addView(PER, LP);
        l1.addView(DIV, LP);
        l2.addView(nums[7], LP);
        l2.addView(nums[8], LP);
        l2.addView(nums[9], LP);
        l2.addView(MUL, LP);
        l3.addView(nums[4], LP);
        l3.addView(nums[5], LP);
        l3.addView(nums[6], LP);
        l3.addView(SUB, LP);
        l4.addView(nums[1], LP);
        l4.addView(nums[2], LP);
        l4.addView(nums[3], LP);
        l4.addView(ADD, LP);
        l5.addView(nums[0], LPZ);
        l5.addView(D, LP);
        l5.addView(EQ, LP);
        ll.addView(l1);
        ll.addView(l2);
        ll.addView(l3);
        ll.addView(l4);
        ll.addView(l5);
        setContentView(ll);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case 10:
                //C
                a = 0;
                b = 0;
                per = 0;
                input = "";
                op = "";
                dflag = false;
                opflag = false;
                result.setText(input);
                break;
            case 11:
                //PER
                if (input != "") {
                    per = Float.parseFloat(input);
                    input = control.Calculation(per, 100, "/");
                    result.setText(input);
                    }
                    break;
            case 12:
                // ADD

                    if (opflag == false){
                        a = Float.parseFloat(input);
                        opflag = true;
                        input = "";
                        dflag = false;
                        result.setText(input);
                        op = "+";}
                    else if (op == ""){
                    op = "+";
                        }
                    else{

                        b = Float.parseFloat(input);
                        input = control.Calculation(a, b, op);
                        result.setText(input);
                        a = Float.parseFloat(input);
                        op = "+";
                        input = "";
                    }
                break;
            case 13:
                // sub
                if (opflag == false){
                    a = Float.parseFloat(input);
                    opflag = true;
                    input = "";
                    dflag = false;
                    result.setText(input);
                    op = "-";}
                else if (op == ""){
                    op = "-";
                }
                else{

                    b = Float.parseFloat(input);
                    input = control.Calculation(a, b, op);
                    op = "-";
                    result.setText(input);
                    a = Float.parseFloat(input);
                    input = "";
                }
                break;
            case 15:
                // div
                if (opflag == false){
                    a = Float.parseFloat(input);
                    opflag = true;
                    input = "";
                    dflag = false;
                    result.setText(input);
                    op = "/";}
                else if (op == ""){
                    op = "/";
                }
                else{

                    b = Float.parseFloat(input);

                    input = control.Calculation(a, b, op);
                    op = "/";
                    result.setText(input);
                    a = Float.parseFloat(input);
                    input = "";
                }
                break;
            case 14:
                // mul
                if (opflag == false){
                    a = Float.parseFloat(input);
                    opflag = true;
                    input = "";
                    dflag = false;
                    result.setText(input);
                    op = "x";}
                else if (op == ""){
                    op = "x";
                }
                else{

                    b = Float.parseFloat(input);
                    input = control.Calculation(a, b, op);
                    op = "x";
                    result.setText(input);
                    a = Float.parseFloat(input);
                    input = "";
                }
                break;
            case 16:
                // eq
                if (opflag == true){
                b = Float.parseFloat(input);
                input = control.Calculation(a, b, op);
                result.setText(input);
                a = Float.parseFloat(input);
                input = "";
                op = "";
                    }
                break;
            case 17:
                // d
                if (dflag == false){
                input += ".";
                dflag = true;
                result.setText(input);}
                break;
            case 18:
                // neg
                if (input.charAt(0) != '-') {
                    input = "-" + input;
                }
                else{
                    StringBuilder sb = new StringBuilder(input);
                    sb.deleteCharAt(0);
                    input = sb.toString();
                    }
                result.setText(input);
                break;
            case 0:
                if (input != ""){
                input += "0";
                result.setText(input);}
                break;
            case 1:
                input += "1";
                result.setText(input);
                break;
            case 2:
                input += "2";
                result.setText(input);
                break;
            case 3:
                input += "3";
                result.setText(input);
                break;
            case 4:
                input += "4";
                result.setText(input);
                break;
            case 5:
                input += "5";
                result.setText(input);
                break;
            case 6:
                input += "6";
                result.setText(input);
                break;
            case 7:
                input += "7";
                result.setText(input);
                break;
            case 8:
                input += "8";
                result.setText(input);
                break;
            case 9:
                input += "9";
                result.setText(input);
                break;
            default:
                break;
        }
    }
}
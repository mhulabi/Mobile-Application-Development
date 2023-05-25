package com.example.calculator;

public class Controller {
    private Model model;
    private MainActivity MA;

    public Controller(MainActivity MA){
        this.MA = MA;
        model = new Model(this);
    }

    public String Calculation(float a, float b, String op){
        return model.Calculation(a, b, op);
    }

    public void Result(String result){
        this.MA.result.setText(result);
    }
}

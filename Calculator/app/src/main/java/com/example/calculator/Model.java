package com.example.calculator;

public class Model {
    private Controller control;

    public Model(Controller control){
        this.control = control;
    }

    public String Calculation(float a, float b, String op){
        float res;

        switch (op){
            case "/":
                if (b != 0){
                res = a / b;}
                else{return "ERROR";}
                break;
            case "x":
                res = a * b;
                break;
            case "-":
                res = a - b;
                break;
            case "+":
                res = a + b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + op);

        }
        return Float.toString(res);
    }
}

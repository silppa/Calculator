package com.example.developer.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView screen;
    String result="";
    String currentoperator="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (TextView) findViewById(R.id.screen);
        result = "";

    }

    public void updateScreen() {
        screen.setText(result);
    }

    public void onClickNumber(View v) {
        Button operand = (Button) v;
        result += operand.getText();
        updateScreen();
    }

    public void onClickOperator(View v) {
        Button operand = (Button) v;
        result += operand.getText();
        currentoperator+=operand.getText().toString();
        updateScreen();
    }
    private double arithematic(String a,String b,String op )
    {
        switch (op) {
            case "+":
                return (Double.valueOf(a) + Double.valueOf(b));
            case "-":
                return (Double.valueOf(a) - Double.valueOf(b));
            case "*":
                return (Double.valueOf(a) * Double.valueOf(b));
            case "/":
                try {
                    return (Double.valueOf(a) / Double.valueOf(b));
                } catch (Exception e) {
                    Log.d("cal", e.getMessage());
                }

            default:return 0;
        }
    }


    public void onClickEqual(View v) {
        double display;
        String[] operation = result.split(Pattern.quote(currentoperator));

        if (operation.length == 1) {
            return ;
        } else if (operation.length == 2) {
            display = arithematic(operation[0], operation[1], currentoperator);
            screen.setText(result + "\n" + display);
        }
    }
    private void clear()
    {
        result="";
        currentoperator="";
    }
    public void onClickClear(View v) {

        clear();
        updateScreen();
    }
}
package com.example.unittools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public  static final double INCH_TO_CM = 2.54;
    public  static final double FT_TO_CM = 30.48;
    public  static final double FT_TO_INCH = 12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init cm, ft, inch
        EditText etCentiMeter = findViewById(R.id.editTextNumberDecimal);
        EditText etFoot = findViewById(R.id.editTextNumberDecimal2);
        EditText etInch = findViewById(R.id.editTextNumberDecimal3);

        etCentiMeter.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_UP){
                    if(etCentiMeter.length() != 0){
                        double cm = Double.parseDouble(etCentiMeter.getText().toString());
                        double ft = cm / FT_TO_CM;
                        double inch = cm / INCH_TO_CM;

                        etFoot.setText(Double.toString(ft));
                        etInch.setText(Double.toString(inch));
                    }else{
                        etFoot.setText("");
                        etInch.setText("");
                    }

                }
                return false;
            }
        });

        etFoot.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(KeyEvent.ACTION_UP == keyEvent.getAction()){
                    if(etFoot.length() != 0){
                        double ft = Double.parseDouble(etFoot.getText().toString());
                        double cm = ft * FT_TO_CM;
                        double inch = ft * FT_TO_INCH;

                        etCentiMeter.setText(Double.toString(cm));
                        etInch.setText(Double.toString(inch));
                    }else{
                        etCentiMeter.setText("");
                        etInch.setText("");
                    }

                }
                return false;
            }
        });

        etInch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(KeyEvent.ACTION_UP == keyEvent.getAction()){
                    if(etInch.length() != 0){
                        double inch = Double.parseDouble(etInch.getText().toString());
                        double cm = inch * INCH_TO_CM;
                        double ft = inch / FT_TO_INCH;

                        etCentiMeter.setText(Double.toString(cm));
                        etFoot.setText(Double.toString(ft));
                    }else{
                        etCentiMeter.setText("");
                        etFoot.setText("");
                    }

                }
                return false;
            }
        });

        //Init clear button
        Button btClear = findViewById(R.id.button);
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etCentiMeter.setText("");
                etFoot.setText("");
                etInch.setText("");
            }
        });

    }
}
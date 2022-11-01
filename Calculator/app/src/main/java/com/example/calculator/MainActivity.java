package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, badd, bsub, bmul, bdiv, blpar, brpar;
    String num1, num2, op;
    Double sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.edit);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        badd = findViewById(R.id.add);
        bsub = findViewById(R.id.sub);
        bmul = findViewById(R.id.mul);
        bdiv = findViewById(R.id.div);
        blpar = findViewById(R.id.lpar);
        brpar = findViewById(R.id.rpar);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + b1.getText().toString());
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + b2.getText().toString());
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + b3.getText().toString());
            }
        });
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + b4.getText().toString());
            }
        });
        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + b5.getText().toString());
            }
        });
        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + b6.getText().toString());
            }
        });
        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + b7.getText().toString());
            }
        });
        findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + b8.getText().toString());
            }
        });
        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + b9.getText().toString());
            }
        });
        findViewById(R.id.btn0).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + b0.getText().toString());
            }
        });
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + badd.getText().toString());
            }
        });
        findViewById(R.id.sub).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + bsub.getText().toString());
            }
        });
        findViewById(R.id.mul).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + bmul.getText().toString());
            }
        });
        findViewById(R.id.div).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + bdiv.getText().toString());
            }
        });
        findViewById(R.id.dot).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + ".");
            }
        });
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (e1.getText().length() >= 1) {
                    e1.setText(e1.getText().toString().toCharArray(), 0, e1.getText().length() - 1);
                }
            }
        });
        findViewById(R.id.lpar).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + blpar.getText().toString());
            }
        });
        findViewById(R.id.rpar).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + brpar.getText().toString());
            }
        });
        findViewById(R.id.eq).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Expression e = new Expression(e1.getText().toString());
                double r = e.calculate();
                String r2 = String.valueOf(r);
                e1.setText(r2);
            }
        });
    }
}
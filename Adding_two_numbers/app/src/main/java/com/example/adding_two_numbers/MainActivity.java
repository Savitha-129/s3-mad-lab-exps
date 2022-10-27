package com.example.adding_two_numbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    EditText e1;
    Button b1;

    String ste;
    int a,c,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        t1=findViewById(R.id.tv1);
        t2=findViewById(R.id.tv2);
        e1=findViewById(R.id.ans);
        b1=findViewById(R.id.bu1);

        Random random=new Random();
        int i= random.nextInt(100);
        int i2= random.nextInt(100);

        t1.setText(""+i);
        t2.setText(""+i2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ste=e1.getText().toString();


                if(TextUtils.isEmpty(ste)){

                    Toast.makeText(getApplicationContext(), "Enter Some Value", Toast.LENGTH_LONG).show();
                }
                else{

                    a=Integer.parseInt(t1.getText().toString());
                    b=Integer.parseInt(t2.getText().toString());
                    c=Integer.parseInt(ste);

                    if((a+b)==c){

                        Toast.makeText(getApplicationContext(), "You Win", Toast.LENGTH_LONG).show();
                    }
                    else{

                        Toast.makeText(getApplicationContext(), "You Lose", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
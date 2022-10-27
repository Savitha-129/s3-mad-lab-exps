package com.example.lay_out;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.bu1);

    }
     public void clickfun(View v)
        {
            RadioGroup rg=findViewById(R.id.r1);
            int radgid = rg.getCheckedRadioButtonId();
            switch(radgid){
                case R.id.b1:
                {
                    Intent n1 = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(n1);
                    break;
                }
                case R.id.b2:
                {
                    Intent n2 =new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(n2);
                    break;
                }
                case R.id.b3:
                {
                    Intent n3 =new Intent(MainActivity.this,MainActivity4.class);
                    startActivity(n3);
                    break;
                }
                case R.id.b4:
                {
                    Intent n4 =new Intent(MainActivity.this,MainActivity5.class);
                    startActivity(n4);
                    break;
                }
                case R.id.b5:
                {
                    Intent n5 =new Intent(MainActivity.this,MainActivity6.class);
                    startActivity(n5);
                    break;
                }
                default:
                {
                    Toast.makeText(this, "Select any option.", Toast.LENGTH_LONG).show();
                }

            }
        }


}
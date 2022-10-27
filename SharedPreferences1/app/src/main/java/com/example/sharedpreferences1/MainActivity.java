package com.example.sharedpreferences1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ME";

    public static final String SHARED_PREFERENCE_NAME = "com.example.com.shared-preferences";
    public static final String SHARED_PREFERENCE_KEY_NUM1 = "NUM1";
    public static final String SHARED_PREFERENCE_KEY_NUM2 = "NUM2";
    public static final String SHARED_PREFERENCE_KEY_LEVEL = "LEVEL";
    public static final String SHARED_PREFERENCE_KEY_SCORE = "SCORE";
    public static final String SHARED_PREFERENCE_KEY_OPERATOR = "OPERATOR";

    private TextView num1;
    private TextView num2;
    private TextView operator;
    private EditText resultEntered;
    private TextView level;
    private TextView score;
    private TextView status;
    private Button nextLevel;

    private SharedPreferences sharedpreferences;

    private void updateScore()
    {
        int scr  = Integer.parseInt(score.getText().toString());
        scr = scr + 10;
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(SHARED_PREFERENCE_KEY_SCORE , scr);
        editor.commit();
        Log.v(TAG , "scr:" + scr);
        score.setText("" + scr);

    }

    private void updateLevel()
    {
        int lvl = Integer.parseInt(score.getText().toString());
        lvl = lvl + 1;
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(SHARED_PREFERENCE_KEY_LEVEL , lvl);
        Log.v(TAG , "lvl:" + lvl);
        editor.commit();
    }

    private void restUI()
    {
        Random r = new Random();
        //int r_num ;
        int lvl = sharedpreferences.getInt(SHARED_PREFERENCE_KEY_LEVEL,1);
        int scr = sharedpreferences.getInt(SHARED_PREFERENCE_KEY_SCORE , 0);
        Log.v(TAG , "resetUI lvl :" +lvl);
        Log.v(TAG , "resetUI scr:" + scr);
        int r1 = r.nextInt(lvl * 10);
        int r2 = r.nextInt(lvl * 10);
        num1.setText("" + r1);
        num2.setText(""+ r2);
        num1.setTextColor(Color.RED);
        num2.setTextColor(Color.RED);

        int op = r.nextInt();
        String opr = "+";
        switch (op)
        {
            case 3 :
                opr = "/";
                if(r1<r2)
                {
                    num1.setText(""+r2);
                    num1.setText(""+r1);
                }
                break;
            case 2:
                opr = "*";
                break;
            case 1:
                opr = "-";
                if(r1<r2)
                {
                    num1.setText(""+r2);
                    num2.setText(""+r1);

                }
                break;

        }
        score.setText(""+scr);
        level.setText(""+lvl);
        operator.setText(opr);
        status.setText("");
        resultEntered.setTextColor(Color.BLACK);
        nextLevel.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedpreferences = getSharedPreferences(SHARED_PREFERENCE_NAME , Context.MODE_PRIVATE);

        num1 = (TextView) findViewById(R.id.tvnum1);
        num2 = (TextView) findViewById(R.id.tvnum2);
        operator = (TextView) findViewById(R.id.tvoperator);

        resultEntered = (EditText) findViewById(R.id.tvsum);
        level = (TextView) findViewById(R.id.tvlevelval);
        score = (TextView) findViewById(R.id.tvscoreval);
        status = (TextView) findViewById(R.id.tvstatus);

        nextLevel = (Button) findViewById(R.id.buttonNextLevel) ;
        nextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateLevel();
                restUI();
            }
        });

        resultEntered.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                if(i == EditorInfo.IME_ACTION_NONE){
                    if(!TextUtils.isEmpty(resultEntered.getText().toString()))
                    {
                        int result = Integer.parseInt(resultEntered.getText().toString());
                        int n1 = Integer.parseInt(num1.getText().toString());
                        int n2 = Integer.parseInt(num2.getText().toString());
                        String opr = operator.getText().toString();
                        int resultActual = 0;
                        switch (opr)
                        {
                            case "+":
                                resultActual = n1+n2;
                                break;
                            case "-":
                                resultActual = n1 - n2;
                                break;
                            case "*":
                                resultActual =n1 * n2;
                                break;
                            case "/":
                                resultActual = n1/n2;
                                break;
                        }

                        if(result == resultActual)
                        {
                            status.setText(R.string.result_correct);
                            status.setTextColor(Color.GREEN);
                            resultEntered.setTextColor(Color.GREEN);
                            nextLevel.setVisibility(View.VISIBLE);
                            updateScore();
                        }
                        else
                        {
                            status.setText(R.string.result_wrong);
                            status.setTextColor(Color.RED);
                            resultEntered.setTextColor(Color.RED);
                            nextLevel.setVisibility(View.INVISIBLE);
                        }
                    }

                }


                return false;
            }
        });

        restUI();
    }
}
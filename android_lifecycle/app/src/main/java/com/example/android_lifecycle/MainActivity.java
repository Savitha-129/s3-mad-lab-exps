package com.example.android_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreate started", Toast.LENGTH_SHORT).show();
        Log.e("MainActivity","onCreate started");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart Called", Toast.LENGTH_SHORT).show();
        Log.e("MainActivity","onCreate started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume started", Toast.LENGTH_SHORT).show();
        Log.e("MainActivity","onResume started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause called", Toast.LENGTH_SHORT).show();
        Log.e("MainActivity","onCreate started");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop started", Toast.LENGTH_SHORT).show();
        Log.e("MainActivity","onStop started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy Called", Toast.LENGTH_SHORT).show();
        Log.e("MainActivity","onCreate started");
    }
}
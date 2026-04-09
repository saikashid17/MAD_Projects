package com.example.myprojects;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnProject1, btnProject2, btnProject3,
            btnProject4, btnProject5, btnProject6,
            btnProject7, btnProject8, btnProject9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProject1 = findViewById(R.id.btnProject1);
        btnProject2 = findViewById(R.id.btnProject2);
        btnProject3 = findViewById(R.id.btnProject3);
        btnProject4 = findViewById(R.id.btnProject4);
        btnProject5 = findViewById(R.id.btnProject5);
        btnProject6 = findViewById(R.id.btnProject6);
        btnProject7 = findViewById(R.id.btnProject7);
        btnProject8 = findViewById(R.id.btnProject8);
        btnProject9 = findViewById(R.id.btnProject9);

        btnProject1.setOnClickListener(v -> openApp(
                "com.example.assign3",
                "com.example.assign3.MainActivity"));

        btnProject2.setOnClickListener(v -> openApp(
                "com.example.assign3a",
                "com.example.assign3a.MainActivity"));

        btnProject3.setOnClickListener(v -> openApp(
                "com.example.profile",
                "com.example.profile.MainActivity"));

        btnProject4.setOnClickListener(v -> openApp(
                "com.example.calculator",
                "com.example.calculator.MainActivity"));

        btnProject5.setOnClickListener(v -> openApp(
                "com.example.implicitintent",
                "com.example.implicitintent.MainActivity"));

        btnProject6.setOnClickListener(v -> openApp(
                "com.example.multiwebsite",
                "com.example.multiwebsite.MainActivity"));

        btnProject7.setOnClickListener(v -> openApp(
                "com.example.explicitintent",
                "com.example.explicitintent.LoginActivity"));

        btnProject8.setOnClickListener(v -> openApp(
                "com.example.alllayouts",
                "com.example.alllayouts.MainActivity"));

    }

    private void openApp(String packageName, String className) {
        Intent intent = new Intent();
        intent.setClassName(packageName, className);
        startActivity(intent);
    }
}
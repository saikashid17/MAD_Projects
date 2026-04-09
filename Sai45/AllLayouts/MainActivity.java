package com.example.alllayouts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnHorizontal, btnVertical, btnConstraint, btnGrid,
            btnRelative, btnFrame, btnAbsolute, btnLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHorizontal = findViewById(R.id.btnHorizontal);
        btnVertical = findViewById(R.id.btnVertical);
        btnConstraint = findViewById(R.id.btnConstraint);
        btnGrid = findViewById(R.id.btnGrid);
        btnRelative = findViewById(R.id.btnRelative);
        btnFrame = findViewById(R.id.btnFrame);
        btnAbsolute = findViewById(R.id.btnAbsolute);
        btnLinear = findViewById(R.id.btnLinear);

        // Horizontal Layout
        btnHorizontal.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClassName(
                    "com.example.linearhorizontallayout",
                    "com.example.linearhorizontallayout.MainActivity"
            );
            startActivity(intent);
        });

        // Vertical Layout
        btnVertical.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClassName(
                    "com.example.linearverticallayout",
                    "com.example.linearverticallayout.MainActivity"
            );
            startActivity(intent);
        });

        // Constraint Layout
        btnConstraint.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClassName(
                    "com.example.constraintlayout",
                    "com.example.constraintlayout.MainActivity"
            );
            startActivity(intent);
        });

        // Grid Layout
        btnGrid.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClassName(
                    "com.example.listlayout",
                    "com.example.listlayout.MainActivity"
            );
            startActivity(intent);
        });

        // Relative Layout
        btnRelative.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClassName(
                    "com.example.relativelayout",
                    "com.example.relativelayout.MainActivity"
            );
            startActivity(intent);
        });

        // Frame Layout
        btnFrame.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClassName(
                    "com.example.framelayout",
                    "com.example.framelayout.MainActivity"
            );
            startActivity(intent);
        });

        // Absolute Layout
        btnAbsolute.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClassName(
                    "com.example.absolutelayout",
                    "com.example.absolutelayout.MainActivity"
            );
            startActivity(intent);
        });

        // Linear Layout
        btnLinear.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClassName(
                    "com.example.tablelayout",
                    "com.example.tablelayout.MainActivity"
            );
            startActivity(intent);
        });
    }
}
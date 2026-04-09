package com.example.absolutelayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(v ->
                Toast.makeText(this,"Button 1 Clicked",Toast.LENGTH_SHORT).show());

        btn2.setOnClickListener(v ->
                Toast.makeText(this,"Button 2 Clicked",Toast.LENGTH_SHORT).show());
    }
}
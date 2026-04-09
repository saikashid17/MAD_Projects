package com.example.multiwebsite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnGoogle, btnYouTube, btnFacebook, btnGithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoogle = findViewById(R.id.btnGoogle);
        btnYouTube = findViewById(R.id.btnYouTube);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnGithub = findViewById(R.id.btnGithub);

        btnGoogle.setOnClickListener(v -> openWebsite("https://www.google.com"));

        btnYouTube.setOnClickListener(v -> openWebsite("https://www.youtube.com"));

        btnFacebook.setOnClickListener(v -> openWebsite("https://www.linkedin.com"));

        btnGithub.setOnClickListener(v -> openWebsite("https://www.github.com"));
    }

    private void openWebsite(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
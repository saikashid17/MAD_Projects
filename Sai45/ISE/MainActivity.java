package com.example.ise;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCamera, btnSubmit;
    ImageView imageView;
    RatingBar ratingBar;
    TextView txtRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = findViewById(R.id.btnCamera);
        btnSubmit = findViewById(R.id.btnSubmit);
        imageView = findViewById(R.id.imageView);
        ratingBar = findViewById(R.id.ratingBar);
        txtRating = findViewById(R.id.textRating);

        btnCamera.setOnClickListener(v -> {

            ratingBar.setRating(0);
            txtRating.setText("");
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);
        });
        btnSubmit.setOnClickListener(v -> {
            float rating = (float) ratingBar.getRating();
            txtRating.setText("Rating = " + rating + " out of 5");
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            imageView.setImageBitmap(
                    (android.graphics.Bitmap) data.getExtras().get("data")
            );
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
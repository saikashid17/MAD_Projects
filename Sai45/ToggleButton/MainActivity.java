package com.example.togglebutton;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.ToggleButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioVeg, radioNonVeg;
    CheckBox checkCheese, checkDrink;
    ToggleButton toggleButton;
    RatingBar ratingBar;
    Spinner spinner;
    ProgressBar progressBar;
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radioVeg = findViewById(R.id.radioVeg);
        radioNonVeg = findViewById(R.id.radioNonVeg);
        checkCheese = findViewById(R.id.checkCheese);
        checkDrink = findViewById(R.id.checkDrink);
        toggleButton = findViewById(R.id.toggleButton);
        ratingBar = findViewById(R.id.ratingBar);
        spinner = findViewById(R.id.spinner);
        progressBar = findViewById(R.id.progressBar);
        btnOrder = findViewById(R.id.btnOrder);

        String[] items = {"Select Restaurant", "Dominos", "KFC", "Heaven"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                String meal = "Not Selected";

                if (selectedId != -1) {
                    RadioButton rb = findViewById(selectedId);
                    meal = rb.getText().toString();
                }

                String extras = "";
                if (checkCheese.isChecked()) extras += "Cheese";
                if (checkDrink.isChecked()) extras += "Drink";

                String delivery = toggleButton.isChecked() ? "Home Delivery" : "Take Away";
                String restaurant = spinner.getSelectedItem().toString();

                float rating = ratingBar.getRating();

                int progress = progressBar.getProgress() + 25;
                progressBar.setProgress(progress);

                String result = "Meal: " + meal +
                        "\nExtras: " + extras +
                        "\nDelivery: " + delivery +
                        "\nRestaurant: " + restaurant +
                        "\nRating: " + rating;

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();


            }
        });
    }
}
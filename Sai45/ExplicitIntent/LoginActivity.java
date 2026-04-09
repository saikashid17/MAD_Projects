package com.example.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText user,pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        user=findViewById(R.id.username);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.loginBtn);

        login.setOnClickListener(v -> {
            if(user.getText().toString().equals("Sai") &&
               pass.getText().toString().equals("1234")) {
                Intent intent= new Intent();
                intent.setClassName(
                        "com.example.profile",
                        "com.example.profile.MainActivity"
                );
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(this, "Profile App not found!", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(LoginActivity.this,"Wrong Username or password",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
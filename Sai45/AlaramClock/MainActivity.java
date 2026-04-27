package com.example.alaramclock;

import android.app.DatePickerDialog;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnPickDate, btnSetAlarm;
    TextView tvDate;
    EditText etReminder;

    Calendar selectedDate = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPickDate = findViewById(R.id.btnPickDate);
        btnSetAlarm = findViewById(R.id.btnSetAlarm);
        tvDate = findViewById(R.id.tvDate);
        etReminder = findViewById(R.id.etReminder);

        // DATE PICKER
        btnPickDate.setOnClickListener(v -> {
            Calendar today = Calendar.getInstance();

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    (view, year, month, dayOfMonth) -> {
                        selectedDate.set(year, month, dayOfMonth);
                        tvDate.setText("Selected Date: " + dayOfMonth + "/" + (month+1) + "/" + year);
                    },
                    today.get(Calendar.YEAR),
                    today.get(Calendar.MONTH),
                    today.get(Calendar.DAY_OF_MONTH)
            );

            // Disable past dates
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

            datePickerDialog.show();
        });

        // SET ALARM
        btnSetAlarm.setOnClickListener(v -> {
            String reminder = etReminder.getText().toString();

            if (reminder.isEmpty()) {
                Toast.makeText(this, "Enter reminder", Toast.LENGTH_SHORT).show();
                return;
            }

            setAlarm(reminder);
        });
    }

    private void setAlarm(String reminderText) {

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.putExtra("reminder", reminderText);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE
        );

        // Set alarm time (example: 9 AM)
        selectedDate.set(Calendar.HOUR_OF_DAY, 9);
        selectedDate.set(Calendar.MINUTE, 0);

        alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                selectedDate.getTimeInMillis(),
                pendingIntent
        );

        Toast.makeText(this, "Alarm Set!", Toast.LENGTH_SHORT).show();
    }
}
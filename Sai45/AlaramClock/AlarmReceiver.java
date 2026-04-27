package com.example.alaramclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String reminder = intent.getStringExtra("reminder");

        Toast.makeText(context, "Reminder: " + reminder, Toast.LENGTH_LONG).show();
    }
}
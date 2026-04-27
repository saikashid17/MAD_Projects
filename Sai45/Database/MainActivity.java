package com.example.filehandling;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etName,etRoll,etDiv,etClass,etDept;
    Button btnSubmit,btnLoad;
    ListView listView;
    ArrayList<String>dataList;
    ArrayAdapter<String>adapter;
    String filename="mydata.txt" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etRoll = findViewById(R.id.etRoll);
        etDiv = findViewById(R.id.etDiv);
        etClass = findViewById(R.id.etClass);
        etDept = findViewById(R.id.etDept);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnLoad = findViewById(R.id.btnLoad);
        listView = findViewById(R.id.listView);

        dataList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
            }
        });
    }
    private void saveData() {
        String name = etName.getText().toString();
        String roll = etRoll.getText().toString();
        String div = etDiv.getText().toString();
        String cls = etClass.getText().toString();
        String dept = etDept.getText().toString();

        if (name.isEmpty() || roll.isEmpty()) {
            Toast.makeText(this, "Please fill form", Toast.LENGTH_SHORT).show();
            return;
        }
        String data = "Name:" + name + ",Roll:" + roll + ",Div:" + div + ",Class:" + cls + ",Dept:" + dept + "\n";
        try {
            FileOutputStream fos = openFileOutput(filename, Context.MODE_APPEND);
            fos.write(data.getBytes());
            fos.close();
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
            clearFields();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadData() {
        dataList.clear();

        try {
            FileInputStream fis = openFileInput(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String line;
            while ((line = reader.readLine()) != null) {
                dataList.add(line);
            }

            reader.close();
            fis.close();

            adapter.notifyDataSetChanged();

        } catch (IOException e) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }
    private void clearFields() {
        etName.setText("");
        etRoll.setText("");
        etDiv.setText("");
        etClass.setText("");
        etDept.setText("");
    }
}
package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Employee extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee);

        button = findViewById(R.id.viewDetails);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Employee.this, ViewProfile.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.EditDetails);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Employee.this, Edit_Profile.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.HolidayRequest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Employee.this, Leave_request.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.logout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Employee.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

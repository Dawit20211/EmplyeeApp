package com.example.firstapplication;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView userName =(TextView) findViewById(R.id.userName);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton loginBtn = (MaterialButton) findViewById(R.id.logInBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if (userName.getText().toString().equals("apples") && password.getText().toString().equals("orange")) {
                Toast.makeText(MainActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Employee.class);
                startActivity(intent);
            } else if (userName.getText().toString().equals("admin") && password.getText().toString().equals("admin123")) {
                Toast.makeText(MainActivity.this,"Admin Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AdminMenu.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this,"LOGIN FAILED, TRY AGAIN WITH ANOTHER USERNAME OR PASSWORD", Toast.LENGTH_SHORT).show();
            }
        }

        });

    }
}
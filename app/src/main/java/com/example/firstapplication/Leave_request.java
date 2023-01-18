package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.util.Pair;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class Leave_request extends AppCompatActivity {

     Button buttonHoliday;
     TextView dates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leave_request);

        Button notificationBtn;
        notificationBtn = findViewById(R.id.button4);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("notify", "Notification", NotificationManager.IMPORTANCE_DEFAULT );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        dates= findViewById(R.id.dates);
        buttonHoliday = findViewById(R.id.editTextDate2);
        MaterialDatePicker.Builder<Pair<Long, Long>> materialDateBuilder = MaterialDatePicker.Builder.dateRangePicker();
        materialDateBuilder.setTitleText("Select Date");
        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();

        buttonHoliday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(),"MATERIAL_DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                dates.setText(materialDatePicker.getHeaderText());
            }

        });

        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Leave_request.this, "notify");
                builder.setContentTitle("NOTIFICATION");
                builder.setPriority(NotificationCompat.PRIORITY_HIGH);
                builder.setContentText("Thank you, your leave request has been submitted you will hear hear back whether it's been app" +
                        "been approved or not in the next three working days");
                builder.setSmallIcon(R.drawable.img);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Leave_request.this);
                managerCompat.notify(1, builder.build());

            }
        });

        Button back;

        back = findViewById(R.id.back_button1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Leave_request.this, Employee.class);
                startActivity(intent);
            }
        });
    }




}
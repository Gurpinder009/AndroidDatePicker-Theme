package com.example.androidthemes;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private TextView reservation;
    private Button dateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        this.reservation = findViewById(R.id.editTextDate);
        this.dateButton = findViewById(R.id.mainBtn);

        Calendar c = Calendar.getInstance();
        DateFormat date = DateFormat.getDateInstance();




        DatePickerDialog.OnDateSetListener d = (datePicker, year, month, day) -> {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, day);
            reservation.setText("your reservation  is set for "+c.getTime());

        };




        dateButton.setOnClickListener(view -> {
            Log.i("info", "onClick:Button Clicked ");
            new DatePickerDialog(MainActivity.this,d,c.get(Calendar.YEAR),c.get(Calendar.MONTH), c.getMaximum(Calendar.DAY_OF_MONTH)).show();
        });

    }
}






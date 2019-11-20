package com.lamlt.my_day.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.lamlt.my_day.R;
import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class YearlyViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearly_view);
        Date today = new Date();
        Calendar nextyear = Calendar.getInstance();
        nextyear.add(Calendar.YEAR, 1);
        CalendarPickerView datePicker = findViewById(R.id.yearlyview);
        datePicker.init(today, nextyear.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(today);


        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);
                Calendar calseclected = Calendar.getInstance();
                calseclected.setTime(date);
                selectedDate = " " + calseclected.get(Calendar.DAY_OF_MONTH) + " /" + (calseclected.get(Calendar.MONTH) + 1) +
                        " /" + calseclected.get(Calendar.YEAR);
                Toast.makeText(YearlyViewActivity.this, selectedDate, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
    }
    }


package com.lamlt.my_day.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;

import com.lamlt.my_day.R;

import java.util.Calendar;

public class MonthlyViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_view);
        Calendar calendar=Calendar.getInstance();

    }
}

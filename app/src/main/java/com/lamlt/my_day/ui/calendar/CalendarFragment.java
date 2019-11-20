package com.lamlt.my_day.ui.calendar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.lamlt.my_day.R;
import com.lamlt.my_day.activity.DailyViewActivity;
import com.lamlt.my_day.activity.MainActivity;
import com.lamlt.my_day.activity.MonthlyViewActivity;
import com.lamlt.my_day.activity.WeeklyViewActivity;
import com.lamlt.my_day.activity.YearlyViewActivity;

public class CalendarFragment extends Fragment {
    private CalendarViewModel calendarViewModel;
    AlertDialog alertDialog;

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.calendar_view_group, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.viewcalendar:
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View alert = LayoutInflater.from(getContext()).inflate(R.layout.dialog_calendar_view_group, null);
                builder.setView(alert);

                RadioGroup radioGroup = alert.findViewById(R.id.rdgcalendar);

                RadioButton rdoviewday = (RadioButton) alert.findViewById(R.id.rdoviewday);
                RadioButton rdoviewweek = (RadioButton) alert.findViewById(R.id.rdoviewweek);
                RadioButton rdoviewmonth = (RadioButton) alert.findViewById(R.id.rdoviewmonth);
                RadioButton rdoviewyear = (RadioButton) alert.findViewById(R.id.rdoviewyear);
                RadioButton rdoeventlist = (RadioButton) alert.findViewById(R.id.rdoeventlist);

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        doOnDifficultyLevelChanged(radioGroup, i);
                    }
                });

                rdoviewday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        doOnChangeCalendarView(compoundButton, b);
                    }
                });
                rdoviewweek.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        doOnChangeCalendarView(compoundButton, b);

                    }
                });

                rdoviewmonth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        doOnChangeCalendarView(compoundButton, b);

                    }
                });

                rdoeventlist.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        doOnChangeCalendarView(compoundButton, b);

                    }
                });
                rdoviewyear.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        doOnChangeCalendarView(compoundButton, b);
                    }
                });

                builder.create().show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        calendarViewModel = ViewModelProviders.of(this).get(CalendarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calendar, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        calendarViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    private void doOnChangeCalendarView(CompoundButton button, boolean isChecked) {
        RadioButton radioButton = (RadioButton) button;
        Log.i("radiobutton", "RadioButton " + radioButton.getText() + " : " + isChecked);
    }

    private void doOnDifficultyLevelChanged(RadioGroup group, int checkedId) {
        int checkRadioId = group.getCheckedRadioButtonId();
        if (checkRadioId == R.id.rdoviewday) {
            Intent intent=new Intent(getContext(), DailyViewActivity.class);
            startActivity(intent);
            Toast.makeText(getContext(), "Daily View", Toast.LENGTH_SHORT).show();

        } else if (checkRadioId == R.id.rdoviewweek) {
            Intent intent=new Intent(getContext(), WeeklyViewActivity.class);
            startActivity(intent);
            Toast.makeText(getContext(), "Weekly View", Toast.LENGTH_SHORT).show();

        } else if (checkRadioId == R.id.rdoviewmonth) {
            Intent intent=new Intent(getContext(),MonthlyViewActivity.class);
            startActivity(intent);
            Toast.makeText(getContext(), "Monthly View", Toast.LENGTH_SHORT).show();

        } else if (checkRadioId == R.id.rdoviewyear) {
            Toast.makeText(getContext(), "Yearly View", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getContext(), YearlyViewActivity.class);
            startActivity(intent);
        } else if (checkRadioId == R.id.rdoeventlist) {
            Toast.makeText(getContext(), "Event List View", Toast.LENGTH_SHORT).show();
        }
    }

}
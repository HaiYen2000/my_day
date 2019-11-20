package com.lamlt.my_day.ui.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.lamlt.my_day.R;

public class SettingFragment extends Fragment {

    private SettingViewModel settingViewModel;
    private Switch switchOnOff;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingViewModel =
                ViewModelProviders.of(this).get(SettingViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_setting, container, false);
        switchOnOff = root.findViewById(R.id.switchOnOff);
        switchOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){

                }else{

                }
            }
        });
        return root;
    }

}
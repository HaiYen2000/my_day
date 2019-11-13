package com.lamlt.my_day.base;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void startNewActivity(Class target){
        Intent intent = new Intent(this,target);
        startActivity(intent);
    }

    public void showMessage(String mess){
        Toast.makeText(this, mess, Toast.LENGTH_SHORT).show();
    }

}

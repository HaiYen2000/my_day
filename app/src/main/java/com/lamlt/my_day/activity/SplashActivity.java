package com.lamlt.my_day.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.lamlt.my_day.R;

import static com.lamlt.my_day.Constants.SPLASH_TIME_OUT;


public class SplashActivity extends AppCompatActivity {

    MediaPlayer startupSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
            getActionBar().hide();
        }else{
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startupSound = MediaPlayer.create(SplashActivity.this, R.raw.android_q_startup);
        startupSound.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, IntroActivity.class));
                finish();
            }
        },SPLASH_TIME_OUT);
    }

    @Override
    protected void onPause() {
        super.onPause();
        startupSound.release();
        finish();
    }
}

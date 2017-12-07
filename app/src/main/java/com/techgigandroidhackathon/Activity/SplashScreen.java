package com.techgigandroidhackathon.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.techgigandroidhackathon.MainActivity;
import com.techgigandroidhackathon.R;

public class SplashScreen extends AppCompatActivity {

    private Intent intent;
    private Handler mHandler;
    private long delayTime = 3 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        initialize();
    }

    /**
     * Initialize variables
     */
    private void initialize() {
        intent = new Intent(this, MainActivity.class);
        mHandler = new Handler();
        mHandler.postDelayed(delayRunnable, delayTime);
    }

    private Runnable delayRunnable = new Runnable() {
        @Override
        public void run() {
            startActivity(intent);
            finish();
        }
    };
}

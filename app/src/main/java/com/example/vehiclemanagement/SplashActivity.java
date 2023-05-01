package com.example.vehiclemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView splashImage = findViewById(R.id.splash_image);
        splashImage.setImageResource(R.drawable.splash_image);
        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over
            // Start your app main activity
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);

            // close this activity
            finish();
        }, SPLASH_TIME_OUT);
    }
}
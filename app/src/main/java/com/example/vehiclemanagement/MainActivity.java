package com.example.vehiclemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button view,available, sold, about, add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.button1);
        available = findViewById(R.id.button2);
        sold = findViewById(R.id.button3);
        about = findViewById(R.id.button4);
        add = findViewById(R.id.button5);

        view.setOnClickListener(view -> {
            Intent intent = new Intent(this,viewActivity.class);
            intent.putExtra("key", "all");
            startActivity(intent);
        });

        available.setOnClickListener(view -> {
            Intent i = new Intent(this,viewActivity.class);
            i.putExtra("key", "available");
            startActivity(i);
        });

        sold.setOnClickListener(view -> {
            Intent i = new Intent(this,viewActivity.class);
            i.putExtra("key", "sold");
            startActivity(i);
        });

        about.setOnClickListener(view -> {
            startActivity(new Intent(this,aboutActivity.class));
        });

        add.setOnClickListener(view -> {
            startActivity(new Intent(this,addActivity.class));
        });
    }
}
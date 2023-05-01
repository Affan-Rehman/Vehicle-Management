package com.example.vehiclemanagement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;




public class viewActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ad.notifyDataSetChanged();
    }

    public static viewActivity getInstance() {
        return instance;
    }
    @SuppressLint("StaticFieldLeak")
    public static viewActivity instance;

    List<Car> allV;
    List<Car> soldV;
    List<Car> availableV;

    TextView back;
    cardViewAdapter ad;
    RecyclerView cardView;
    LinearLayoutManager layout;
    private void addCars(){
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Car>>() {}.getType();
        //THIS READS FROM .JSON FILE
        String filename = "myObjects.json";
        File file = new File(getFilesDir(), filename);
        allV = null;
        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                allV = gson.fromJson(reader, type);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            allV = new ArrayList<>();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        cardView = findViewById(R.id.cardView);
        instance = this;
        layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        back = findViewById(R.id.back1);

        Intent extras = getIntent();
        String value = extras.getStringExtra("key");

        allV = new ArrayList<>();
        soldV = new ArrayList<>();
        availableV = new ArrayList<>();


      addCars();

        for(Car car : allV){
            if(car.sold)
                soldV.add(car);
            else
                availableV.add(car);
        }


        back.setOnClickListener(view -> finish());


        if(Objects.equals(value, "all")){
            cardView.setLayoutManager(layout);
            ad = new cardViewAdapter(this, allV);
            cardView.setAdapter(ad);
        }

        if(Objects.equals(value, "sold")){
            cardView.setLayoutManager(layout);
            ad = new cardViewAdapter(this, soldV);
            cardView.setAdapter(ad);
        }

        if(Objects.equals(value, "available")){
            cardView.setLayoutManager(layout);
            ad = new cardViewAdapter(this, availableV,"available",allV);
            cardView.setAdapter(ad);
        }
    }
}
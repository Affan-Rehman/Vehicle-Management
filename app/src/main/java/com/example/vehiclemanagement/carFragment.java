package com.example.vehiclemanagement;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Objects;


public class carFragment extends Fragment {
    Car car;
    TextView back;
    String check;
    List<Car> allV;
    public carFragment() {
        // Required empty public constructor
    }


    public carFragment(Car car,String check,List<Car> cars){
        this.car = car;
        this.check = check;
        this.allV = cars;
    }
    public void updateCarsInJsonFile(List<Car> newCars) {
        Gson gson = new Gson();

        try (Writer writer = new FileWriter(new File(viewActivity.getInstance().getFilesDir(), "myObjects.json"))) {
            gson.toJson(newCars, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root;
        if(Objects.equals(check, "available")){
             root = inflater.inflate(R.layout.fragment_car2, container, false);
            root.findViewById(R.id.image1).setBackground(getResources().getDrawable(car.image, getActivity().getTheme()));

            EditText textView1 = root.findViewById(R.id.e1);
            textView1.setText(car.name);

            EditText textView2 = root.findViewById(R.id.e2);
            textView2.setText(car.model);

            EditText textView3 = root.findViewById(R.id.e3);
            textView3.setText( car.color);

            EditText textView4 = root.findViewById(R.id.e4);
            textView4.setText(car.condition);

            EditText textView5 = root.findViewById(R.id.e5);
            textView5.setText(car.year);

            EditText textView6 = root.findViewById(R.id.e6);
            textView6.setText( car.doors);

            EditText textView7 = root.findViewById(R.id.e7);
            textView7.setText(car.engine);

            TextView textView8 = root.findViewById(R.id.t8);
            textView8.setText("Price: " + car.price + "$");


            TextView textView9 = root.findViewById(R.id.t9);
            textView9.setText("available");
            Button confirmButton = root.findViewById(R.id.confirm_button);
            confirmButton.setOnClickListener(view -> {
               car.setName(textView1.getText().toString());
                car.setModel(textView2.getText().toString());
                car.setColor(textView3.getText().toString());
                car.setCondition(textView4.getText().toString());
                car.setYear(textView5.getText().toString());
                car.setDoors(textView6.getText().toString());
                car.setEngine(textView7.getText().toString());
                updateCarsInJsonFile(allV);
                Toast.makeText(viewActivity.getInstance(), "Done", Toast.LENGTH_SHORT).show();
            });
            back = root.findViewById(R.id.back4);
            back.setOnClickListener(view -> {
                FragmentManager fragmentManager = viewActivity.getInstance().getFragmentManager();
                fragmentManager.popBackStackImmediate();
                if (fragmentManager.getBackStackEntryCount() == 0)
                    viewActivity.getInstance().onBackPressed();
            });
        }
        // Inflate the layout for this fragment
        else{
            root = inflater.inflate(R.layout.fragment_car, container, false);
            root.findViewById(R.id.image).setBackground(getResources().getDrawable(car.image, getActivity().getTheme()));
            TextView textView1 = root.findViewById(R.id.t1);
            textView1.setText("Name: " + car.name);

            TextView textView2 = root.findViewById(R.id.t2);
            textView2.setText("Model: " + car.model);

            TextView textView3 = root.findViewById(R.id.t3);
            textView3.setText("Color: " + car.color);

            TextView textView4 = root.findViewById(R.id.t4);
            textView4.setText("Condition: " + car.condition);

            TextView textView5 = root.findViewById(R.id.t5);
            textView5.setText("Year: " + car.year);

            TextView textView6 = root.findViewById(R.id.t6);
            textView6.setText("Number of doors: " + car.doors);

            TextView textView7 = root.findViewById(R.id.t7);
            textView7.setText("Engine: " + car.engine);

            TextView textView8 = root.findViewById(R.id.t8);
            textView8.setText("Price: " + car.price + "$");


            TextView textView9 = root.findViewById(R.id.t9);
            String text;
            if (!car.sold)
                text = "available";
            else
                text = "Sold";
            textView9.setText(text);

            TextView textVie10 = root.findViewById(R.id.t10);
            if (car.sold)
                textVie10.setText("Date: " + car.date);

            back = root.findViewById(R.id.back3);

            back.setOnClickListener(view -> {
                FragmentManager fragmentManager = viewActivity.getInstance().getFragmentManager();
                fragmentManager.popBackStackImmediate();
                if (fragmentManager.getBackStackEntryCount() == 0)
                    viewActivity.getInstance().onBackPressed();
            });


        }
        return root;
    }
}
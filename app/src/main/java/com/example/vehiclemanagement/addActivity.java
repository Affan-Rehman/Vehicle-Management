package com.example.vehiclemanagement;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class addActivity extends AppCompatActivity {

    Button add;
    EditText name,price,sold,condition,doors,engine,year,model,date,color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name = findViewById(R.id.name_text);
        price = findViewById(R.id.price_text);
        sold = findViewById(R.id.a_text);
        condition = findViewById(R.id.condition_text);
        doors = findViewById(R.id.doors_text);
        engine = findViewById(R.id.engine_text);
        year = findViewById(R.id.year_text);
        model = findViewById(R.id.model_text);
        date = findViewById(R.id.date_text);
        color = findViewById(R.id.color_text);
        add = findViewById(R.id.button_submit);

        add.setOnClickListener(view -> {
            String nameS = name.getText().toString();
            String priceS = price.getText().toString();
            String soldS = sold.getText().toString();
            String conS = condition.getText().toString();
            String doorS = doors.getText().toString();
            String engS = engine.getText().toString();
            String yearS = year.getText().toString();
            String modelS = model.getText().toString();
            String dateS = date.getText().toString();
            String colS = color.getText().toString();


            if (nameS.equals("")) {
                name.setError("Please Enter Name");
                return;
            }
            if (priceS.equals("")) {
                price.setError("Please Enter Price");
                return;
            }
            if (conS.equals("")) {
                condition.setError("Please Enter Condition");
                return;
            }
            if (doorS.equals("")) {
                doors.setError("Please Enter Doors");
                return;
            }
            if (engS.equals("")) {
                engine.setError("Please Enter Doors");
                return;
            }
            if (yearS.equals("")) {
                year.setError("Please Enter Year");
                return;
            }
            if (modelS.equals("")) {
                model.setError("Please Enter Model");
                return;
            }
            if (soldS.equals("true")) {
                if(dateS.equals("")) {
                    date.setError("Please Enter Date");
                    return;
                }
            }
            if (colS.equals("")) {
                color.setError("Please Enter Color");
                return;
            }
            if (!soldS.equals("true") && !soldS.equals("false")){
                sold.setError("Please Enter true or false");
                return;
            }


            Car myObject = new Car(nameS,Integer.parseInt(priceS),Boolean.parseBoolean(soldS),modelS,conS,engS,yearS,doorS,colS,dateS, 0);
            DialogActivity dialogActivity = new DialogActivity(addActivity.this, myObject,this);
            dialogActivity.show();


        });
    }
}
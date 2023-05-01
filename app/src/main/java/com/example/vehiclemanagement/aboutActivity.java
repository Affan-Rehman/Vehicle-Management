package com.example.vehiclemanagement;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class aboutActivity extends AppCompatActivity {
    TextView back;
    Company company;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        // Access the EditText views
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button = findViewById(R.id.button_confirm);


        try {
            readCompanyFromJsonFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        editText1.setText(company.name);
        editText2.setText(company.address);
        editText3.setText(company.sales);
        ImageView imageView = findViewById(R.id.cImage);

        button.setOnClickListener(v -> {
            // Get the text from the EditText views
            String text1 = editText1.getText().toString();
            String text2 = editText2.getText().toString();
            String text3 = editText3.getText().toString();

            company.address = text2;
            company.sales = text3;
            company.name = text1;
            DialogActivity dialogActivity = new DialogActivity(aboutActivity.this, company,this,"company");
            dialogActivity.show();

        });
        back = findViewById(R.id.back2);
        back.setOnClickListener(view -> finish());


        if(company.image!=0)
         imageView.setBackground(getResources().getDrawable(company.image,getTheme()));
    }



    public void readCompanyFromJsonFile() throws IOException {
        String filename = "company.json";
        Gson gson = new Gson();
        File file = new File(getFilesDir(), filename);
        if (!file.exists()) {
            company =  new Company("","","",0);
        }
        try (Reader reader = new FileReader(file)) {
            company = gson.fromJson(reader, Company.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
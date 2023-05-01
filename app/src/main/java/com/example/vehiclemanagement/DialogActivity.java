package com.example.vehiclemanagement;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

public class DialogActivity extends Dialog {

    private addActivity mActivity;
    private  aboutActivity a;
    public void writeGson(Car myObject) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Car>>() {}.getType();

        String filename = "myObjects.json";
        File file = new File(mActivity.getFilesDir(), filename);
        //THIS WRITES TO .JSON FILE
        ArrayList<Car> myObjects = null;
        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                myObjects = gson.fromJson(reader, type);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            myObjects = new ArrayList<>();
        }

        myObjects.add(myObject);

        try (Writer writer = new FileWriter(file)) {
            gson.toJson(myObjects, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private GridView mGridView;
    private Car mCar;
    String check;
    Company company;
    private int[] mImageIds = {
            R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,
            R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8,
            R.drawable.image9, R.drawable.image10
    };

    public DialogActivity(Context context, Car car,addActivity a) {
        super(context);
        this.mActivity = a;
        this.mCar = car;
    }
    public DialogActivity(Context context, Company company,aboutActivity a,String check) {
        super(context);
        this.a = a;
        this.company = company;
        this.check = check;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);

        mGridView = findViewById(R.id.gridView);
        mGridView.setAdapter( new ImageAdapter(getContext()));
        mGridView.setOnItemClickListener((parent, view, position, id) -> {
            if(Objects.equals(check, "company")){
                company.setImage(mImageIds[position]);
                try {
                    writeGsonCompany(company);
                    a.findViewById(R.id.cImage).setBackground(a.getResources().getDrawable(mImageIds[position]));
                    Toast.makeText(a,"Done!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                mCar.setImage(mImageIds[position]);
                writeGson(mCar);
                Toast.makeText(mActivity,"Done!", Toast.LENGTH_SHORT).show();
            }
            dismiss();


        });
    }

    private void writeGsonCompany(Company company) throws IOException {
        String filename = "company.json";
        Gson gson = new Gson();
        File file = new File(a.getFilesDir(), filename);
        String json = gson.toJson(company);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(json);
        fileWriter.close();
    }

    private class ImageAdapter extends BaseAdapter {

        private Context mContext;

        public ImageAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return mImageIds.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mImageIds[position]);
            return imageView;
        }
    }
}


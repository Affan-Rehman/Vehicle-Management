package com.example.vehiclemanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


//This class is our main class that displays the animals in a list
public class cardViewAdapter extends RecyclerView.Adapter<cardViewAdapter.ViewHolder> {
    private static List<Car> list;
    private final LayoutInflater inflater;
    Context context;
    String check = "";
    List<Car> allV;
    cardViewAdapter(Context context, List<Car> list,String check,List<Car> allv) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        cardViewAdapter.list = list;
        this.check = check;
        this.allV = allv;

    }
    cardViewAdapter(Context context, List<Car> list) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        cardViewAdapter.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.card_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car object = list.get(position);
        holder.name.setText(object.name);
        if(!object.sold)
            holder.make.setText("Available");
        else
            holder.make.setText("Sold");

        holder.price.setText(object.price + "$");

        holder.name.setOnClickListener(view ->{
            carFragment fragment = new carFragment(object,check,allV);
            FragmentTransaction transaction = viewActivity.getInstance().getSupportFragmentManager().beginTransaction();
            transaction.addToBackStack(null);
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.fragment, fragment).commit();
        });

        holder.make.setOnClickListener(view ->{
            carFragment fragment = new carFragment(object,check,allV);
            FragmentTransaction transaction = viewActivity.getInstance().getSupportFragmentManager().beginTransaction();
            transaction.addToBackStack(null);
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.fragment, fragment).commit();
        });
        holder.price.setOnClickListener(view ->{
            carFragment fragment = new carFragment(object,check,allV);
            FragmentTransaction transaction = viewActivity.getInstance().getSupportFragmentManager().beginTransaction();
            transaction.addToBackStack(null);
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.fragment, fragment).commit();
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,make,price;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            name = view.findViewById(R.id.name);
            make = view.findViewById(R.id.make);
            price = view.findViewById(R.id.price);


        }
    }
}

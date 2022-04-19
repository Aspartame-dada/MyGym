package com.example.myloginactivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myloginactivity.Dao.Foods;
import com.example.myloginactivity.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    Context context;
    List<Foods> data;

    public FoodAdapter(Context context, List<Foods> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.food_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Foods foods = data.get(position);
        holder.food_name.setText(String.valueOf(foods.getFood_name()));
        holder.food_k.setText(String.valueOf(foods.getFood_k()));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView food_name,food_k;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            food_name=itemView.findViewById(R.id.tv_food);
            food_k=itemView.findViewById(R.id.tv_karoie);
            layout=itemView.findViewById(R.id.layout_food);
        }
    }
}

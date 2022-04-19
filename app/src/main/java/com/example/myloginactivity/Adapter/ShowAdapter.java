package com.example.myloginactivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myloginactivity.Dao.Goods;
import com.example.myloginactivity.R;

import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {
    List<Goods> data;
    Context context;

    public ShowAdapter(Context context,List<Goods> data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.show_item, parent, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Goods goods=data.get(position);
       holder.name.setText(String.valueOf(goods.getGoods_name()));
       holder.money.setText(String.valueOf(goods.getGoods_sum()*goods.getGoods_selling_price())+"元");


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,money;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_show_name);
            money = itemView.findViewById(R.id.tv_show_money);
        }
    }
}

package com.example.myloginactivity.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myloginactivity.Content.GoodsContentActivity;
import com.example.myloginactivity.Content.LostContentActivity;
import com.example.myloginactivity.Content.VipContentActivity;
import com.example.myloginactivity.Dao.Goods;
import com.example.myloginactivity.R;

import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ViewHolder> {
    // 我们一般会传三个参数
    private Context context;
    // 这个地方需要一个数据类型，就是我们需要的一个数据，这边我还是用StudentInfo
    private List<ButtonInfo> data;
    private GoodsContentActivity GoodsContentActivity;
    private LostContentActivity lostContentActivity;
    private VipContentActivity vipContentActivity;
    // 然后就是我们点击的回调接口，没有点击事件的话就算求，
    Activity[] activities= {
            GoodsContentActivity,lostContentActivity,vipContentActivity
    };

    public ButtonAdapter(Context context, List<ButtonInfo> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.button_item, parent, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ButtonInfo buttonInfo = data.get(position);
        holder.imageView.setImageResource(buttonInfo.getImage());
        holder.textView.setText(buttonInfo.getText());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (buttonInfo.getText()){
                    case "商品管理":
                        context.startActivity(new Intent(v.getContext(), com.example.myloginactivity.Content.GoodsContentActivity.class));
                        break;
                    case "会员信息管理":
                        context.startActivity(new Intent(v.getContext(), com.example.myloginactivity.Content.VipContentActivity.class));
                        break;
                    case "遗失物品管理":
                        context.startActivity(new Intent(v.getContext(), com.example.myloginactivity.Content.LostContentActivity.class));
                        break;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public int itemId(int position){
        return position;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
            textView = itemView.findViewById(R.id.textView2);
            layout = itemView.findViewById(R.id.layout);

        }
    }
}

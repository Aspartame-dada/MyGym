package com.example.myloginactivity.Adapter.Manage;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myloginactivity.Dao.TeachInfo;
import com.example.myloginactivity.MainActivity;
import com.example.myloginactivity.R;

import org.litepal.LitePal;

import java.util.List;


public class TeachInfoAdapter extends RecyclerView.Adapter<TeachInfoAdapter.ViewHolder> {
    Context context;
    List<TeachInfo> data;
    @NonNull
    @Override
    public TeachInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.teach_info_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeachInfoAdapter.ViewHolder holder, int position) {
        TeachInfo teachInfo = data.get(position);
        holder.tv_name.setText(String.valueOf(teachInfo.getTaech_name()));
        holder.tv_direction.setText(String.valueOf(teachInfo.getTeach_direction()));
        holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog alert = null;
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());;
                alert = builder
                        .setTitle("系统提示：")
                        .setMessage("您确认删除当前信息么")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), "你点击了取消按钮~", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LitePal.deleteAll(TeachInfo.class,"trach_id=?", String.valueOf( teachInfo.getTeach_id()));
                                context.startActivity(new Intent(context, MainActivity.class));
                            }
                        }).create();             //创建AlertDialog对象
                alert.show();
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_direction;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.tv_teach_name);
            tv_direction=itemView.findViewById(R.id.tv_teach_direction);
            layout=itemView.findViewById(R.id.layout_teach);
        }
    }
}

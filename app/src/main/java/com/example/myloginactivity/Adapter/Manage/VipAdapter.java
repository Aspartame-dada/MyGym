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

import com.example.myloginactivity.Dao.Vip;
import com.example.myloginactivity.MainActivity;
import com.example.myloginactivity.R;

import org.litepal.LitePal;

import java.util.List;

public class VipAdapter extends RecyclerView.Adapter<VipAdapter.ViewHolder> {
    Context context;
    List<Vip> data;

    public VipAdapter(Context context, List<Vip> data) {
        this.context = context;
        this.data = data;
    }
//展示的页面样式
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.vip_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vip vip = data.get(position);
        holder.tv_vip_id.setText(String.valueOf(vip.getVip_id()));
        holder.tv_vip_name.setText(vip.getVip_name());
        holder.tv_vip_birthday.setText(vip.getVip_birthday());
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
                                LitePal.deleteAll(Vip.class,"id=?", String.valueOf(vip.getVip_id()));
                                context.startActivity(new Intent(context, MainActivity.class));
                            }
                        }).create();             //创建AlertDialog对象
                alert.show();
                return false;
            }
        });




    }
//告诉适配器，你需要展示几条数据
    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_vip_id,tv_vip_name,tv_vip_birthday;
        LinearLayout layout ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_vip_id=itemView.findViewById(R.id.tv_vip_id);
            tv_vip_name=itemView.findViewById(R.id.tv_vip_name);
            tv_vip_birthday=itemView.findViewById(R.id.tv_vip_birthday);
            layout=itemView.findViewById(R.id.layout_vip);
            layout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return false;
                }
            });
        }
    }
}

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

import com.example.myloginactivity.Dao.Goods;
import com.example.myloginactivity.Dao.Lost;
import com.example.myloginactivity.MainActivity;
import com.example.myloginactivity.R;

import org.litepal.LitePal;

import java.util.List;

public class LostAdapter  extends RecyclerView.Adapter<LostAdapter.ViewHolder>{
    private Context context;
    // 这个地方需要一个数据类型，就是我们需要的一个数据
    private List<Lost> data;

    public LostAdapter(Context context, List<Lost> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.lost_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lost lost =data.get(position);
        holder.tv_lost_id.setText(String.valueOf(lost.getLost_id()));
        holder.tv_lost_name.setText(String.valueOf(lost.getLost_name()));
        holder.tv_lost_place.setText(String.valueOf(lost.getLost_place()));
        holder.tv_lost_get_phone.setText(String.valueOf(lost.getLost_get_phone()));
        holder.tv_lost_time.setText(String.valueOf(lost.getLost_time()));
        holder.tv_lost_status.setText(String.valueOf(lost.isLost_status()));
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
                                LitePal.deleteAll(Lost.class,"lost_id=?", String.valueOf( lost.getLost_id()));
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
        TextView tv_lost_id,tv_lost_name,tv_lost_place,tv_lost_time,tv_lost_get_phone,tv_lost_status;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_lost_id=itemView.findViewById(R.id.tv_lost_id);
            tv_lost_name=itemView.findViewById(R.id.tv_lost_name);
            tv_lost_place = itemView.findViewById(R.id.tv_lost_place);
            tv_lost_time = itemView.findViewById(R.id.tv_lost_time);
            tv_lost_get_phone = itemView.findViewById(R.id.tv_lost_get_phone);
            tv_lost_status = itemView.findViewById(R.id.tv_lost_status);
            layout=itemView.findViewById(R.id.laout_lost);


        }
    }
}

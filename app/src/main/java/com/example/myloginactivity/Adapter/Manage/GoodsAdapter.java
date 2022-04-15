package com.example.myloginactivity.Adapter.Manage;

import static androidx.core.content.ContextCompat.startActivity;

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

import com.example.myloginactivity.Adapter.ButtonAdapter;
import com.example.myloginactivity.Adapter.ButtonInfo;
import com.example.myloginactivity.Dao.Goods;
import com.example.myloginactivity.MainActivity;
import com.example.myloginactivity.R;

import org.litepal.LitePal;

import java.util.List;

public class GoodsAdapter  extends RecyclerView.Adapter<GoodsAdapter.ViewHolder>{
    private Context context;
    // 这个地方需要一个数据类型，就是我们需要的一个数据，这边我还是用StudentInfo
    private List<Goods> data;

    public GoodsAdapter(Context context, List<Goods> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public GoodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.goods_item_layout, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsAdapter.ViewHolder holder, int position) {
        Goods goods =data.get(position);
        holder.goods_id.setText(String.valueOf(goods.getGoods_id()));
        holder.tv_goods_buying_price.setText(String.valueOf( goods.getGoods_buying_price()));
        holder.tv_goods_selling_price.setText(String.valueOf(goods.getGoods_selling_price()));
        holder.tv_goods_in_stocks.setText(String.valueOf(goods.getGoods_in_stocks()));
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
                                Goods goods = data.get(0);
                                LitePal.deleteAll(Goods.class,"goods_id=?", String.valueOf( goods.getGoods_id()));
                                context.startActivity(new Intent(context,MainActivity.class));
                                Toast.makeText(v.getContext(), "你点击了确定按钮~", Toast.LENGTH_SHORT).show();
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
        TextView goods_id,tv_goods_in_stocks,tv_goods_selling_price,tv_goods_buying_price;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            goods_id = itemView.findViewById(R.id.tv_goods_id);
            tv_goods_buying_price = itemView.findViewById(R.id.tv_goods_buying_price);
            tv_goods_selling_price = itemView.findViewById(R.id.tv_goods_selling_price);
            tv_goods_in_stocks = itemView.findViewById(R.id.tv_goods_in_stocks);
            layout = itemView.findViewById(R.id.laout_goods);
        }
    }
}

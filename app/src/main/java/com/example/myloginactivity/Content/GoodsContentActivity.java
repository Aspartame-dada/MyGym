package com.example.myloginactivity.Content;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myloginactivity.Adapter.Manage.GoodsAdapter;
import com.example.myloginactivity.Dao.Goods;
import com.example.myloginactivity.MainActivity;
import com.example.myloginactivity.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.litepal.LitePal;

import java.util.List;

public class GoodsContentActivity extends AppCompatActivity {

    private RecyclerView rvGoods;
    private FloatingActionButton flatingGoods;
    GoodsAdapter goodsAdapter;
    List<Goods> goods;
    private ImageButton btnGoodsBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_content);
        initView();
    }

    private void initView() {
        rvGoods = (RecyclerView) findViewById(R.id.rv_goods);
        findAllGoods();

        goodsAdapter = new GoodsAdapter(this, goods);
        rvGoods.setAdapter(goodsAdapter);
        rvGoods.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        flatingGoods = (FloatingActionButton) findViewById(R.id.flating_goods);
        flatingGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GoodsAddActivity.class));
            }
        });

        btnGoodsBack = (ImageButton) findViewById(R.id.btn_goods_back);
        btnGoodsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    public void findAllGoods() {
        goods = LitePal.findAll(Goods.class);

//        goodsAdapter.notifyDataSetChanged();

    }
}
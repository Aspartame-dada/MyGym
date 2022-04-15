package com.example.myloginactivity.Content;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myloginactivity.Adapter.Manage.VipAdapter;
import com.example.myloginactivity.Dao.Vip;
import com.example.myloginactivity.MainActivity;
import com.example.myloginactivity.R;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class VipContentActivity extends AppCompatActivity {

    private ImageButton btnVipBack;
    private RecyclerView rvVip;
    List<Vip> vip;
    VipAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_content);
        initView();
    }

    private void initView() {
        btnVipBack = (ImageButton) findViewById(R.id.btn_vip_back);
        rvVip = (RecyclerView) findViewById(R.id.rv_vip);
        findVip();
        adapter =new VipAdapter(this,vip);
        rvVip.setAdapter(adapter);
        rvVip.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));



        btnVipBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
    public void findVip(){
        vip=new ArrayList<>();
        vip.add(new Vip(1,"aa","aa","aa","2000/01/01"));
                vip = LitePal.findAll(Vip.class);

    }
}
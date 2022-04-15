package com.example.myloginactivity.Content;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myloginactivity.Adapter.Manage.LostAdapter;
import com.example.myloginactivity.Dao.Goods;
import com.example.myloginactivity.Dao.Lost;
import com.example.myloginactivity.MainActivity;
import com.example.myloginactivity.R;
import com.example.myloginactivity.Users.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.litepal.LitePal;

import java.util.List;

public class LostContentActivity extends AppCompatActivity {

    private ImageButton btnLostBack;
    private RecyclerView rvLost;
    private FloatingActionButton flatingLost;
    LostAdapter lostAdapter;
    List<Lost> lost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_content);
        initView();
    }

    private void initView() {
        btnLostBack = (ImageButton) findViewById(R.id.btn_lost_back);
        rvLost = (RecyclerView) findViewById(R.id.rv_lost);
        findAllLost();
        lostAdapter=new LostAdapter(this,lost);
        rvLost.setAdapter(lostAdapter);
        rvLost.setLayoutManager(new LinearLayoutManager(this ,LinearLayoutManager.VERTICAL,false));
        flatingLost = (FloatingActionButton) findViewById(R.id.flating_lost);


        flatingLost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnLostBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });
    }
    public void findAllLost() {
        lost = LitePal.findAll(Lost.class);

//        goodsAdapter.notifyDataSetChanged();

    }

}
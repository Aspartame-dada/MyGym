package com.example.myloginactivity;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myloginactivity.Adapter.ShowAdapter;
import com.example.myloginactivity.Dao.Foods;
import com.example.myloginactivity.Dao.Goods;
import com.lixs.charts.PieChartView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PieChartWithline extends AppCompatActivity {

    private PieChartView pieView;
    List<Goods> data;
    private RecyclerView rvShow;
    ShowAdapter showAdapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart_withline);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initView() {
        pieView = (PieChartView) findViewById(R.id.pieView);
        initPieDatas();
        rvShow = (RecyclerView) findViewById(R.id.rv_show);
        data=LitePal.findAll(Goods.class);
        data.sort(Comparator.comparing(Goods::getGoods_sum));
        showAdapter=new ShowAdapter(this,data);
        rvShow.setAdapter(showAdapter);
        rvShow.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }

    private void initPieDatas() {
        data = LitePal.findAll(Goods.class);

        List<Float> mRatios = new ArrayList<>();

        List<String> mDescription = new ArrayList<>();

        List<Integer> mArcColors = new ArrayList<>();
        float sum=0;
        for (int i=0;i<data.size();i++){
            int color = (int) ((-1)*(1+Math.random()*(99999999-999999+1)));
            mArcColors.add(color);
            sum +=(float) ((float)data.get(i).getGoods_sum()*data.get(i).getGoods_selling_price());
            mDescription.add(data.get(i).getGoods_name());
        }
        for (int i=0;i<data.size();i++){
            mRatios.add((float) ((float)data.get(i).getGoods_sum()*data.get(i).getGoods_selling_price())/sum);

        }


        //点击动画开启
        pieView.setCanClickAnimation(true);
        pieView.setDatas(mRatios, mArcColors, mDescription);
    }

}
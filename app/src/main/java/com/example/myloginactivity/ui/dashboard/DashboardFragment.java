package com.example.myloginactivity.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myloginactivity.Adapter.ButtonAdapter;
import com.example.myloginactivity.Adapter.ButtonInfo;
import com.example.myloginactivity.R;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {
    private RecyclerView recyclerView;
    private ButtonAdapter buttonAdapter;
    private ArrayList<ButtonInfo> mlist;
    int[] imageId={R.drawable.ic_teach,R.drawable.ic_apparatus,R.drawable.ic_vip,R.drawable.ic_goods,R.drawable.ic_lost};
    String[] text={"教练管理","器械管理","会员信息管理","商品管理","遗失物品管理"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_dashboard, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mlist = new ArrayList<>();
        buttonAdapter = new ButtonAdapter(this.getContext(),mlist);
        recyclerView.setAdapter(buttonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        initData();

    }
    private void initData() {
        // 1. 设置基本数据
        for (int i = 0; i < imageId.length; i++) {
            mlist.add(new ButtonInfo(imageId[i],text[i]));
        }
        // 2. 进行刷新
        buttonAdapter.notifyDataSetChanged();
    }
}
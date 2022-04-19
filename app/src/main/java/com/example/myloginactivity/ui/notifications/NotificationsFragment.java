package com.example.myloginactivity.ui.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myloginactivity.Adapter.FoodAdapter;
import com.example.myloginactivity.Dao.Foods;
import com.example.myloginactivity.Dao.UserInfo;
import com.example.myloginactivity.R;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;


public class NotificationsFragment extends Fragment {


    private EditText etSearch;
    private Button btnSearch;
    private RecyclerView rvFood;
    String search_food;
    List<Foods> foods;
    FoodAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    private void initView(View view) {
        etSearch = (EditText) view.findViewById(R.id.et_search);
        btnSearch = (Button) view.findViewById(R.id.btn_search);
        rvFood = (RecyclerView) view.findViewById(R.id.rv_food);
        addFoods();
        foods =new ArrayList<> ();
        adapter= new FoodAdapter(getContext(),foods);
        rvFood.setAdapter(adapter);
        rvFood.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_food=etSearch.getText().toString().trim();
                if(check()){
                    checkUsers();
                }else {
                    Toast.makeText(getContext(),"请检查您的输入后再进行查询",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean check(){
        if(search_food.isEmpty()){
            return false;
        }else {
            return true;
        }

    }

    public void checkUsers() {
        List<Foods> users = LitePal.findAll(Foods.class);
        Log.i("TAG", "checkUsers:  ---------------"+users.size());

        for (int i = 0; i < users.size(); i++) {
            Log.i("TAG", "checkUsers:  ---------------"+String.valueOf(users.get(i).getFood_name()));
            if (users.get(i).getFood_name().contains(search_food)) {
                foods.add(users.get(i));
                adapter= new FoodAdapter(getContext(),foods);
                rvFood.setAdapter(adapter);
                rvFood.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));

                Toast.makeText(getContext(),"查询成功",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getContext(),"该种食物暂未收录，敬请期待",Toast.LENGTH_SHORT).show();

            }
        }


    }

    public void addFoods(){
        List<Foods> foods=new ArrayList<>();
        foods.add(new Foods("黄瓜","热量：16k/100g"));
        foods.add(new Foods("拍黄瓜","热量：32k/100g"));
        foods.add(new Foods("炒黄瓜","热量：32k/100g"));
        foods.add(new Foods("酸黄瓜","热量：31k/100g"));
        foods.add(new Foods("乳黄瓜","热量：36k/100g"));
        foods.add(new Foods("1","热量：36k/100g"));
        foods.add(new Foods("11","热量：36k/100g"));
        foods.add(new Foods("111","热量：36k/100g"));

        LitePal.saveAll(foods);



    }}
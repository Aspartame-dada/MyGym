package com.example.myloginactivity.Users;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myloginactivity.Dao.Foods;
import com.example.myloginactivity.Dao.UserInfo;
import com.example.myloginactivity.R;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etUsername;
    private EditText etPasswordSet;
    private EditText etPasswordComfirm;
    private Button btnConfirm;
    String name=null;
    String password=null;
    String password_confirm=null;
    UserInfo users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPasswordSet = (EditText) findViewById(R.id.et_password_set);
        etPasswordComfirm = (EditText) findViewById(R.id.et_password_comfirm);
        btnConfirm = (Button) findViewById(R.id.btn_confirm);
        btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirm:
                if(isEmptyForText()){
                    if(isSamePassword()){
                        register();
                    }

                }
                break;
        }
    }
public void register(){
    users = new UserInfo(name,password);
    users.save();
    //注册成功，返回登录页面
    startActivity(new Intent(this,LoginActivity.class));
}
    //判断输入内容是否为空
    public boolean isEmptyForText(){
        name=etUsername.getText().toString().trim();
        password=etPasswordSet.getText().toString().trim();
        password_confirm=etPasswordComfirm.getText().toString().trim();
        if(name.isEmpty()|password.isEmpty()|password_confirm.isEmpty()){
            Toast.makeText(this,"输入内容为空",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
    public boolean isSamePassword(){
        password=etPasswordSet.getText().toString().trim();
        password_confirm=etPasswordComfirm.getText().toString().trim();
        if(password.equals(password_confirm)){
            return true;
        }
        return false;
    }

}
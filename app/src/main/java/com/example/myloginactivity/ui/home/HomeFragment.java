package com.example.myloginactivity.ui.home;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.myloginactivity.PieChartWithline;
import com.example.myloginactivity.R;
import com.example.myloginactivity.zxing.android.CaptureActivity;


public class HomeFragment extends Fragment implements View.OnClickListener{
    private ImageButton imageButton;
    private TextView textView3;
    private ImageButton imageButton2;
    private TextView textView4;
    private static final String DECODED_CONTENT_KEY = "codedContent";
    private static final String DECODED_BITMAP_KEY = "codedBitmap";
    private static final int REQUEST_CODE_SCAN = 0x0000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initView(View view) {
        imageButton = (ImageButton) view.findViewById(R.id.imageButton);
        imageButton2 = (ImageButton) view.findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton:
                //动态权限申请
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1);
                } else {
                    goScan();
                }
                break;
            case R.id.imageButton2:
                startActivity(new Intent(getContext(), PieChartWithline.class));
                break;
        }
    }
    /**
     * 跳转到扫码界面扫码
     */
    private void goScan(){
        Intent intent = new Intent(getContext(), CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SCAN);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    goScan();
                } else {
                    Toast.makeText(getContext(), "你拒绝了权限申请，可能无法打开相机扫码哟！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                //返回的文本内容
                String content = data.getStringExtra(DECODED_CONTENT_KEY);
                //返回的BitMap图像
                Bitmap bitmap = data.getParcelableExtra(DECODED_BITMAP_KEY);

//                tv_scanResult.setText("你扫描到的内容是：" + content);
            }
        }
    }
}
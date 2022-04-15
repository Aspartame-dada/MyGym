package com.example.myloginactivity.base;

import android.view.View;

import androidx.annotation.NonNull;


public abstract class HolderBaseRecycler<T> extends HolderBase<T> {


    public HolderBaseRecycler(@NonNull View itemView) {
        super(itemView);
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}

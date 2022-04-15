package com.example.myloginactivity.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HolderBase<T> extends RecyclerView.ViewHolder {
    //    最基本的holder；

    public HolderBase(@NonNull View itemView) {
        super(itemView);
    }

    public void bindHolder(T t) {

    }
    public void bindHolder(T t, Object object) {
    }

    public void bindHolder(T t, Object obj0, Object obj1) {
    }

    public void bindHolder(T t, Object obj0, Object obj1, Object obj2) {
    }

    public void unbindHolder() {
    }

}

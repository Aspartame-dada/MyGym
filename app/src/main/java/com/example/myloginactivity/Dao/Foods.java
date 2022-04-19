package com.example.myloginactivity.Dao;

import org.litepal.crud.LitePalSupport;

public class Foods extends LitePalSupport {
    String food_name;
    String food_k;

    public Foods(String food_name, String food_k) {
        this.food_name = food_name;
        this.food_k = food_k;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_k() {
        return food_k;
    }

    public void setFood_k(String food_k) {
        this.food_k = food_k;
    }
}

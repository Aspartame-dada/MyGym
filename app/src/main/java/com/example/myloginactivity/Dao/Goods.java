package com.example.myloginactivity.Dao;

import org.litepal.crud.LitePalSupport;

public class Goods extends LitePalSupport {
    int goods_id;
    String goods_name;
    double goods_buying_price;
    double goods_selling_price;
    int goods_in_stocks;
    int goods_sum;

    public Goods() {
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public int getGoods_sum() {
        return goods_sum;
    }

    public void setGoods_sum(int goods_sum) {
        this.goods_sum = goods_sum;
    }

    public Goods(int goods_id, String goods_name, double goods_buying_price, double goods_selling_price, int goods_in_stocks, int goods_sum) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_buying_price = goods_buying_price;
        this.goods_selling_price = goods_selling_price;
        this.goods_in_stocks = goods_in_stocks;
        this.goods_sum = goods_sum;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public double getGoods_buying_price() {
        return goods_buying_price;
    }

    public void setGoods_buying_price(double goods_buying_price) {
        this.goods_buying_price = goods_buying_price;
    }

    public double getGoods_selling_price() {
        return goods_selling_price;
    }

    public void setGoods_selling_price(double goods_selling_price) {
        this.goods_selling_price = goods_selling_price;
    }

    public int getGoods_in_stocks() {
        return goods_in_stocks;
    }

    public void setGoods_in_stocks(int goods_in_stocks) {
        this.goods_in_stocks = goods_in_stocks;
    }
}

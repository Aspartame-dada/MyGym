package com.example.myloginactivity.Dao;

import org.litepal.crud.LitePalSupport;

public class Vip extends LitePalSupport {
    int id;
    String vip_name;
    String vip_status;
    String data;
    String vip_birthday;

    public Vip() {
    }

    public Vip(int id, String vip_name, String vip_status, String data, String vip_birthday) {
        this.id = id;
        this.vip_name = vip_name;
        this.vip_status = vip_status;
        this.data = data;
        this.vip_birthday = vip_birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVip_name() {
        return vip_name;
    }

    public void setVip_name(String vip_name) {
        this.vip_name = vip_name;
    }

    public String isVip_status() {
        return vip_status;
    }

    public void setVip_status(String vip_status) {
        this.vip_status = vip_status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getVip_birthday() {
        return vip_birthday;
    }

    public void setVip_birthday(String vip_birthday) {
        this.vip_birthday = vip_birthday;
    }
}

package com.example.myloginactivity.Dao;

import org.litepal.crud.LitePalSupport;

public class Apparatus  extends LitePalSupport {
    String apparatus_name;
    int id;
    String info;

    public Apparatus() {
    }

    public Apparatus(String apparatus_name, int id, String info) {
        this.apparatus_name = apparatus_name;
        this.id = id;
        this.info = info;
    }

    public String getApparatus_name() {
        return apparatus_name;
    }

    public void setApparatus_name(String apparatus_name) {
        this.apparatus_name = apparatus_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

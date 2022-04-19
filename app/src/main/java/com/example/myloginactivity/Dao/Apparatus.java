package com.example.myloginactivity.Dao;

import org.litepal.crud.LitePalSupport;

public class Apparatus  extends LitePalSupport {
    String apparatus_name;
    int appatatus_id;
    String info;

    public Apparatus() {
    }

    public Apparatus(String apparatus_name, int id, String info) {
        this.apparatus_name = apparatus_name;
        this.appatatus_id = id;
        this.info = info;
    }

    public String getApparatus_name() {
        return apparatus_name;
    }

    public void setApparatus_name(String apparatus_name) {
        this.apparatus_name = apparatus_name;
    }

    public int getAppatatus_id() {
        return appatatus_id;
    }

    public void setAppatatus_id(int appatatus_id) {
        this.appatatus_id = appatatus_id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

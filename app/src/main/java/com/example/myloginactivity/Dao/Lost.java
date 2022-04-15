package com.example.myloginactivity.Dao;

import org.litepal.crud.LitePalSupport;

public class Lost extends LitePalSupport {
    int lost_id;
    String lost_name;
    String lost_place;
    String lost_time;
    String lost_get_phone;
    boolean lost_status;

    public Lost() {
    }

    public Lost(int lost_id, String lost_name, String lost_place, String lost_time, String lost_get_phone, boolean lost_status) {
        this.lost_id = lost_id;
        this.lost_name = lost_name;
        this.lost_place = lost_place;
        this.lost_time = lost_time;
        this.lost_get_phone = lost_get_phone;
        this.lost_status = lost_status;
    }

    public int getLost_id() {
        return lost_id;
    }

    public void setLost_id(int lost_id) {
        this.lost_id = lost_id;
    }

    public String getLost_name() {
        return lost_name;
    }

    public void setLost_name(String lost_name) {
        this.lost_name = lost_name;
    }

    public String getLost_place() {
        return lost_place;
    }

    public void setLost_place(String lost_place) {
        this.lost_place = lost_place;
    }

    public String getLost_time() {
        return lost_time;
    }

    public void setLost_time(String lost_time) {
        this.lost_time = lost_time;
    }

    public String getLost_get_phone() {
        return lost_get_phone;
    }

    public void setLost_get_phone(String lost_get_phone) {
        this.lost_get_phone = lost_get_phone;
    }

    public boolean isLost_status() {
        return lost_status;
    }

    public void setLost_status(boolean lost_status) {
        this.lost_status = lost_status;
    }
}

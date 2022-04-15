package com.example.myloginactivity.Dao;

import org.litepal.crud.LitePalSupport;

public class TeachInfo extends LitePalSupport {
    int teach_id;
    String taech_name;
    String teach_time;
    String teach_direction;
    String teach_phone;

    public TeachInfo(int teach_id, String taech_name, String teach_time, String teach_direction, String teach_phone) {
        this.teach_id = teach_id;
        this.taech_name = taech_name;
        this.teach_time = teach_time;
        this.teach_direction = teach_direction;
        this.teach_phone = teach_phone;
    }

    public TeachInfo() {
    }

    public int getTeach_id() {
        return teach_id;
    }

    public void setTeach_id(int teach_id) {
        this.teach_id = teach_id;
    }

    public String getTaech_name() {
        return taech_name;
    }

    public void setTaech_name(String taech_name) {
        this.taech_name = taech_name;
    }

    public String getTeach_time() {
        return teach_time;
    }

    public void setTeach_time(String teach_time) {
        this.teach_time = teach_time;
    }

    public String getTeach_direction() {
        return teach_direction;
    }

    public void setTeach_direction(String teach_direction) {
        this.teach_direction = teach_direction;
    }

    public String getTeach_phone() {
        return teach_phone;
    }

    public void setTeach_phone(String teach_phone) {
        this.teach_phone = teach_phone;
    }
}

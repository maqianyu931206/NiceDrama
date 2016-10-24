package com.maqianyu.nicedrama.myset.speech;

/**
 * Created by dllo on 16/10/24.
 */
public class SettingLvBean {
    private String name;
    private int img;

    public SettingLvBean() {
    }

    public SettingLvBean(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

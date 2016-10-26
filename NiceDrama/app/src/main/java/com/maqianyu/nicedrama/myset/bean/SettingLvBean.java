package com.maqianyu.nicedrama.myset.bean;

/**
 * Created by dllo on 16/10/24.
 * 我的  页面ListView的实体类
 * @author 庞美
 */
public class SettingLvBean {
    private String name;
    private int img;
    private String size;

    public SettingLvBean() {
    }

    public SettingLvBean(String name, int img,String size) {
        this.name = name;
        this.img = img;
        this.size = size;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

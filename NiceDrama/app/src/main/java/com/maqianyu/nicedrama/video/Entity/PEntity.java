package com.maqianyu.nicedrama.video.Entity;

/**
 * Created by dllo on 16/10/20.
 * eventBus的实体类
 * @author 张宏迪
 */
public class PEntity {
    private int position;
    private String url;

    public PEntity() {
    }

    public PEntity(int position, String url) {
        this.position = position;
        this.url = url;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

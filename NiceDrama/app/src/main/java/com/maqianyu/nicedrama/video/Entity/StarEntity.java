package com.maqianyu.nicedrama.video.Entity;

/**
 * Created by dllo on 16/10/26.
 * 收藏的实体类
 */
public class StarEntity {

    private String title;
    private String url;
    private String imgUrl;

    public StarEntity() {
    }

    public StarEntity(String title, String url, String imgUrl) {
        this.title = title;
        this.url = url;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

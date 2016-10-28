package com.maqianyu.nicedrama.map.quickhead;


import android.content.Context;

/**
 * User:lizhangqu(513163535@qq.com)
 * Date:2015-11-28
 * Time: 19:55
 */
public class Content extends QuickRvAdapter {
    private int TYPE = 2;
    private String title;
    private String desc;
    private String url;

    public Content(Context context) {
        super(context);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIconUrl() {
        return url;
    }

    public void setIconUrl(String iconUrl) {
        this.url = iconUrl;
    }

    @Override
    public String toString() {
        return "Content{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", icon=" + url +
                '}';
    }

    public int getType() {
        return TYPE;
    }
}

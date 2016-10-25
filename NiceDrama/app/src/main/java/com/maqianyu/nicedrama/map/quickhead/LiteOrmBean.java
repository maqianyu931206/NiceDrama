package com.maqianyu.nicedrama.map.quickhead;

import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by dllo on 16/10/25.
 */
@Table("nicedrama")
public class LiteOrmBean {
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;
    @NotNull
    private String imgUrl;
    private String title;

    public LiteOrmBean() {
    }

    public LiteOrmBean(int id, String imgUrl, String title) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.title = title;
    }

    public LiteOrmBean(String imgUrl, String title) {
        this.imgUrl = imgUrl;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

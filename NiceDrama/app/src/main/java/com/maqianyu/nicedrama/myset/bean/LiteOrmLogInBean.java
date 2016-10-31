package com.maqianyu.nicedrama.myset.bean;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by dllo on 16/10/26.
 * 登录实体类
 * @author 庞美
 */
@Table("user")
public class LiteOrmLogInBean {
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;

    private String name;

    private String password;
    private String number;
    private boolean type;

    public LiteOrmLogInBean() {
    }

    public LiteOrmLogInBean(int id, String name, String password, String number, boolean type) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.number = number;
        this.type = type;
    }

    public LiteOrmLogInBean(String name, String password, String number, boolean type) {
        this.name = name;
        this.password = password;
        this.number = number;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}

